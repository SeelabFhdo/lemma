#!/usr/bin/env bash
#
# Detect security smells in LEMMA service models, without an Eclipse.
#
# Compiles the Xtend of this bundle and the one it reads models with, then runs
# the detection. The classpath comes from an Eclipse installation, because this
# repository has no headless build and the bundles resolve their dependencies
# from a target platform - the same arrangement reconstruct.sh uses.
#
# Usage:
#   tools/detect-smells.sh <model-or-folder>… [--report <file>]
#   tools/detect-smells.sh --no-build <model-or-folder>…    reuse the last compile
#
# Environment:
#   LEMMA_ECLIPSE   Eclipse installation to take the classpath from
#                   (default: /Applications/Eclipse DSL.app/Contents/Eclipse)
set -euo pipefail

BUNDLE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORKSPACE="$(cd "$BUNDLE/.." && pwd)"
BUILD="$BUNDLE/.headless"
ECLIPSE="${LEMMA_ECLIPSE:-/Applications/Eclipse DSL.app/Contents/Eclipse}"

BUILD_SOURCES=1
ARGS=()
for argument in "$@"; do
    if [[ "$argument" == "--no-build" ]]; then BUILD_SOURCES=0; else ARGS+=("$argument"); fi
done

if [[ ! -d "$ECLIPSE/plugins" ]]; then
    echo "No Eclipse installation at: $ECLIPSE" >&2
    echo "Set LEMMA_ECLIPSE to one that has the Xtext and Xtend bundles." >&2
    exit 1
fi

eclipse_classpath() {
    find "$ECLIPSE/plugins" -maxdepth 1 -name "*.jar" ! -name "*.source_*" \
        | grep -E "/(org\.eclipse\.(xtext|xtend|emf|equinox\.common|equinox\.registry\
|equinox\.preferences|core\.runtime|core\.jobs|core\.commands|core\.contenttype\
|core\.resources|core\.filesystem|core\.expressions|core\.databinding|osgi|jdt\.core\
|text|jface|swt|ui|e4\.ui|e4\.core)|com\.google\.(guava|inject)|javax\.inject\
|jakarta\.inject|jakarta\.annotation-api_3|org\.antlr|org\.apache\.(log4j|commons)\
|javax\.annotation|org\.objectweb|org\.osgi)" \
        | grep -v "jakarta.inject-api_1" \
        | tr '\n' ':'
}

COMPILER_CP="$(eclipse_classpath)"
WORKSPACE_BINS="$(find "$WORKSPACE" -maxdepth 2 -type d -name bin | tr '\n' ':')"
# A project compiled below must not also reach the classpath through its
# Eclipse-built bin/: the same class twice makes Xtend resolve the stale copy,
# which surfaces as "cannot convert from Finding to Finding" or as a method
# that plainly exists being reported undefined.
COMPILED_PROJECTS="de.fhdo.lemma.servicedsl.smells.validation|de.fhdo.lemma.servicedsl.diagram|de.fhdo.lemma.servicedsl.smells"
WORKSPACE_BINS="$(printf '%s' "$WORKSPACE_BINS" | tr ':' '\n' \
    | grep -vE "/($COMPILED_PROJECTS)/bin/?$" | tr '\n' ':')"
FULL_CP="$COMPILER_CP$WORKSPACE_BINS"

if [[ "$BUILD_SOURCES" == 1 ]]; then
    echo "Compiling the Xtend of the rule, the reader and the detector..." >&2
    rm -rf "$BUILD"
    mkdir -p "$BUILD/classes"
    # The rule bundle comes first and is compiled rather than taken from its
    # bin/: it holds ChannelVerdict and RootCause, which the detector calls, so
    # relying on a prebuilt bin/ silently judges a system with a stale rule.
    #
    # $BUILD/classes also has to precede the workspace bin/ directories on
    # every classpath below. A bundle that has been built in the IDE has a
    # bin/ holding an older copy of the same classes, and whichever comes
    # first wins: with it last, this script compiled the new rule and then
    # type-checked the detector against the old one.
    for project in "$WORKSPACE/de.fhdo.lemma.servicedsl.smells.validation" \
                   "$WORKSPACE/de.fhdo.lemma.servicedsl.diagram" "$BUNDLE"; do
        name="$(basename "$project")"
        generated="$project/.headless-src"
        rm -rf "$generated" && mkdir -p "$generated"

        java -cp "$COMPILER_CP" org.eclipse.xtend.core.compiler.batch.Main \
            -cp "$BUILD/classes:$FULL_CP" -d "$generated" "$project/src" \
            > "$BUILD/$name.log" 2>&1 || true
        if grep -qE "^ERROR" "$BUILD/$name.log"; then
            grep -A3 "^ERROR" "$BUILD/$name.log" | sort -u >&2
            echo "Xtend compilation of $name failed; see $BUILD/$name.log" >&2
            rm -rf "$generated"; exit 1
        fi

        # --release matches Bundle-RequiredExecutionEnvironment, so a method
        # newer than the bundle's Java fails here rather than in the IDE.
        # shellcheck disable=SC2046
        if ! javac -nowarn -proc:none --release 11 -d "$BUILD/classes" \
            -cp "$BUILD/classes:$FULL_CP" $(find "$generated" -name "*.java") \
            > "$BUILD/$name.javac" 2>&1; then
            grep -E "error:|^[0-9]+ error" "$BUILD/$name.javac" >&2 || cat "$BUILD/$name.javac" >&2
            rm -rf "$generated"; exit 1
        fi
        rm -rf "$generated"
        echo "  $name compiled" >&2
    done
fi

if [[ ! -d "$BUILD/classes" ]]; then
    echo "Nothing compiled yet; run without --no-build first." >&2
    exit 1
fi

exec java -cp "$BUILD/classes:$FULL_CP" \
    de.fhdo.lemma.servicedsl.smells.cli.SmellDetectionCli "${ARGS[@]+"${ARGS[@]}"}"
