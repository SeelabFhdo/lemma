"""Check that a bundle declares the dependencies its sources actually use.

Resolves every package the sources import against the ``Export-Package`` of the
bundles the manifest requires, following ``visibility:=reexport`` as Eclipse
does, and reports the ones nothing exports.

This exists because the headless build cannot catch a missing ``Require-Bundle``
entry: it compiles against a flat classpath of every jar of the Eclipse
installation, which ignores OSGi boundaries, so a bundle can compile there and
fail to resolve inside Eclipse. See ../../de.fhdo.lemma.reconstruction/tools/README.md
for what the headless build does and does not prove.

Usage:
    python3 tools/check-bundle-requires.py <bundle-directory>

Environment:
    LEMMA_ECLIPSE   Eclipse installation whose plugins are the target platform
                    (default: /Applications/Eclipse DSL.app/Contents/Eclipse)

Exits non-zero when a package cannot be resolved, so it can gate a commit.

@author Philip Wizenty <philip.wizenty@fh-dortmund.de>
"""
import os
import re
import sys
import zipfile
from pathlib import Path

ECLIPSE = Path(os.environ.get(
    "LEMMA_ECLIPSE", "/Applications/Eclipse DSL.app/Contents/Eclipse"))
PLUGINS = ECLIPSE / "plugins"

JRE_PACKAGES = ("java.", "javax.", "org.w3c.dom", "org.xml.sax")
"""Packages the platform supplies, which no bundle has to export."""

# The workspace holds the de.fhdo.lemma.* bundles, which are required like any
# other and export their packages the same way.
WORKSPACE = Path(__file__).resolve().parents[2]


def unfold(text):
    """Join OSGi manifest continuation lines (a line starting with a space)."""
    out = []
    for line in text.splitlines():
        if line.startswith((" ", "\t")) and out:
            out[-1] += line[1:]
        else:
            out.append(line)
    return out


def headers(text):
    result = {}
    for line in unfold(text):
        if ":" in line:
            key, _, value = line.partition(":")
            result[key.strip()] = value.strip()
    return result


def split_clauses(value):
    """Split on commas that are not inside quotes."""
    clauses, current, quoted = [], "", False
    for char in value:
        if char == '"':
            quoted = not quoted
        if char == "," and not quoted:
            clauses.append(current)
            current = ""
        else:
            current += char
    if current.strip():
        clauses.append(current)
    return [c.strip() for c in clauses if c.strip()]


def parse_clause(clause):
    """Split a manifest clause into its value and its directives."""
    parts = re.split(r";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", clause)
    return parts[0].strip(), [p.strip() for p in parts[1:]]


def bundle_index():
    """symbolic name -> (exported packages, re-exported required bundles)."""
    index = {}
    manifests = list(PLUGINS.glob("*.jar"))
    for jar in manifests:
        if ".source_" in jar.name:
            continue
        try:
            with zipfile.ZipFile(jar) as archive:
                text = archive.read("META-INF/MANIFEST.MF").decode("utf-8", "replace")
        except (KeyError, zipfile.BadZipFile, OSError):
            continue
        add(index, text)
    for manifest in WORKSPACE.glob("*/META-INF/MANIFEST.MF"):
        add(index, manifest.read_text(encoding="utf-8", errors="replace"))
    return index


def add(index, text):
    head = headers(text)
    name = head.get("Bundle-SymbolicName", "")
    if not name:
        return
    name = parse_clause(name)[0].strip()
    exports = set()
    for clause in split_clauses(head.get("Export-Package", "")):
        exports.add(parse_clause(clause)[0].strip())
    reexports = set()
    for clause in split_clauses(head.get("Require-Bundle", "")):
        required, directives = parse_clause(clause)
        if any("reexport" in d for d in directives):
            reexports.add(required.strip())
    index.setdefault(name, (exports, reexports))


def closure(roots, index):
    """Packages visible to a bundle: what its requirements export, plus what
    those re-export, transitively."""
    seen, pending, packages = set(), list(roots), set()
    while pending:
        name = pending.pop()
        if name in seen:
            continue
        seen.add(name)
        exports, reexports = index.get(name, (set(), set()))
        packages |= exports
        pending.extend(reexports)
    return packages, seen


def own_packages(bundle):
    """Packages the bundle itself holds, read from its source tree."""
    packages = set()
    for root in ("src", "src-gen", "xtend-gen"):
        base = bundle / root
        for source in base.rglob("*.xtend"):
            packages.add(str(source.parent.relative_to(base)).replace("/", "."))
        for source in base.rglob("*.java"):
            packages.add(str(source.parent.relative_to(base)).replace("/", "."))
    return packages


def embedded_packages(bundle, manifest):
    """Packages of jars on the Bundle-ClassPath, which need no Require-Bundle."""
    packages = set()
    for clause in split_clauses(manifest.get("Bundle-ClassPath", "")):
        entry = parse_clause(clause)[0].strip()
        if entry in ("", "."):
            continue
        for jar in bundle.glob(entry):
            try:
                with zipfile.ZipFile(jar) as archive:
                    for name in archive.namelist():
                        if name.endswith(".class") and "/" in name:
                            packages.add(name.rsplit("/", 1)[0].replace("/", "."))
            except (zipfile.BadZipFile, OSError):
                continue
    return packages


def imported_package_header(manifest):
    """Packages the manifest declares through Import-Package.

    The other way a bundle states a dependency: on a package rather than on the
    bundle that holds it. Either declaration makes the package visible.
    """
    return {parse_clause(c)[0].strip()
            for c in split_clauses(manifest.get("Import-Package", ""))}


def missing_classpath(bundle, manifest):
    """Bundle-ClassPath entries that are not on disk.

    Their packages cannot be resolved, and saying so is better than reporting
    them as a missing requirement.
    """
    return [entry for entry in (
                parse_clause(c)[0].strip()
                for c in split_clauses(manifest.get("Bundle-ClassPath", "")))
            if entry not in ("", ".") and not list(bundle.glob(entry))]


def package_of(qualified):
    """The package part of a qualified name.

    Everything before the first capitalised segment: a package segment is
    lowercase and a type segment is not, so this also handles a nested type and
    a static member import, where what follows the type is a member rather than
    a package.
    """
    parts = []
    for part in qualified.split("."):
        if part[:1].isupper():
            break
        parts.append(part)
    return ".".join(parts)


def imported_packages(bundle):
    """Packages the sources refer to, by import or by a qualified reference."""
    packages = set()
    for source in bundle.rglob("*.xtend"):
        for line in source.read_text(encoding="utf-8").splitlines():
            stripped = line.strip()
            # A comment may name a package as an example rather than use one.
            if stripped.startswith(("//", "*", "/*")):
                continue
            match = re.match(r"import (?:static )?(?:extension )?([\w.]+)", stripped)
            if match:
                packages.add(package_of(match.group(1)))
                continue
            # A string may hold something that looks like a qualified name -
            # an editor id, for one - without referring to a package at all.
            code = re.sub(r'"[^"]*"', '""', line)
            for match in re.finditer(
                    r"\b((?:org|com|de|io|net)(?:\.[a-z]\w*)+\.[A-Z]\w*)", code):
                packages.add(package_of(match.group(1)))
    return {p for p in packages if p}


def main(bundle_dir):
    if not PLUGINS.is_dir():
        print(f"No Eclipse installation at: {ECLIPSE}", file=sys.stderr)
        print("Set LEMMA_ECLIPSE to one that has the Xtext and Xtend bundles.",
              file=sys.stderr)
        return 2

    bundle = Path(bundle_dir)
    if not (bundle / "META-INF/MANIFEST.MF").is_file():
        print(f"Not a bundle (no META-INF/MANIFEST.MF): {bundle}", file=sys.stderr)
        return 2

    manifest = headers((bundle / "META-INF/MANIFEST.MF").read_text(encoding="utf-8"))
    required = [parse_clause(c)[0].strip()
                for c in split_clauses(manifest.get("Require-Bundle", ""))]

    index = bundle_index()
    missing_bundles = [r for r in required if r not in index]
    visible, resolved = closure(required, index)
    visible |= own_packages(bundle)
    visible |= embedded_packages(bundle, manifest)
    visible |= imported_package_header(manifest)
    absent = missing_classpath(bundle, manifest)

    print(f"bundle:   {bundle.name}")
    print(f"required: {len(required)} bundles, {len(resolved)} resolved with re-exports")
    if missing_bundles:
        print("!! Require-Bundle names not found in the target platform:")
        for name in missing_bundles:
            print(f"   {name}")
    if absent:
        print(f"?? {len(absent)} Bundle-ClassPath entries are not on disk, so "
              "what they hold cannot be checked:")
        for entry in absent[:5]:
            print(f"   {entry}")
        if len(absent) > 5:
            print(f"   ... and {len(absent) - 5} more")

    unresolved = sorted(
        package for package in imported_packages(bundle)
        if not package.startswith(JRE_PACKAGES)
        and package not in visible
    )
    if unresolved:
        print("!! imported but not exported by any required bundle:")
        for package in unresolved:
            provider = sorted(n for n, (e, _) in index.items() if package in e)
            hint = f"  -> add {provider[0]}" if provider else "  -> no bundle exports it"
            print(f"   {package}{hint}")
        return 1
    print("OK: every imported package is reachable through Require-Bundle")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print(__doc__)
        sys.exit(2)
    sys.exit(main(sys.argv[1]))
