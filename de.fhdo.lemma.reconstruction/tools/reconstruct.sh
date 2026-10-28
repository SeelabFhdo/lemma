#!/usr/bin/env bash
#
# Generate the LEMMA models of a reconstructed system without the wizard.
#
# Compiles the Xtend of the two bundles the reconstruction needs, then runs
# HeadlessReconstruction against the database MRF filled. The classpath comes
# from an Eclipse installation, because this repository has no headless build and
# the bundles resolve their dependencies from a target platform.
#
# Usage:
#   tools/reconstruct.sh --target <folder> [options]
#   tools/reconstruct.sh --no-build --target <folder>    reuse the last compile
#
# Every other option is passed through; see --help.
#
# Environment:
#   LEMMA_ECLIPSE   Eclipse installation to take the classpath from
#                   (default: /Applications/Eclipse DSL.app/Contents/Eclipse)

set -euo pipefail

BUNDLE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORKSPACE="$(cd "$BUNDLE/.." && pwd)"
BUILD="$BUNDLE/.headless"
ECLIPSE="${LEMMA_ECLIPSE:-/Applications/Eclipse DSL.app/Contents/Eclipse}"
EXTRACTOR="$WORKSPACE/de.fhdo.lemma.servicedsl.extractor"

BUILD_SOURCES=1
ARGS=()
for arg in "$@"; do
    case "$arg" in
        --no-build) BUILD_SOURCES=0 ;;
        *) ARGS+=("$arg") ;;
    esac
done

if [[ ! -d "$ECLIPSE/plugins" ]]; then
    echo "No Eclipse installation at: $ECLIPSE" >&2
    echo "Set LEMMA_ECLIPSE to one that has the Xtext and Xtend bundles." >&2
    exit 1
fi

# The jars of the languages, the modelling framework and the runtime they need.
# Not every plugin of the installation: unrelated ones register service providers
# that take over the JVM's file system or logging and make the compiler fail.
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
BUNDLE_LIBS="$(find "$BUNDLE/lib" -name "*.jar" | tr '\n' ':')"
FULL_CP="$COMPILER_CP$WORKSPACE_BINS$BUNDLE_LIBS"

if [[ "$BUILD_SOURCES" == 1 ]]; then
    echo "Compiling the Xtend of the extractor and the reconstruction bundle..."
    rm -rf "$BUILD"
    for project in "$EXTRACTOR" "$BUNDLE"; do
        name="$(basename "$project")"
        # The output has to share a parent with the sources, so it is generated
        # beside them and the classes are moved out afterwards.
        generated="$project/.headless-src"
        log="$BUILD/$name.log"
        rm -rf "$generated" && mkdir -p "$generated" "$BUILD"

        # The Xtend compiler reports an error and still exits zero, so what it
        # produced is what says whether it worked.
        java -cp "$COMPILER_CP" org.eclipse.xtend.core.compiler.batch.Main \
            -cp "$FULL_CP$BUILD/classes" -d "$generated" "$project/src" > "$log" 2>&1 || true
        grep -E "^ERROR|cannot be resolved|is not applicable|Type mismatch" "$log" \
            | sort -u || true
        if [[ -z "$(find "$generated" -name "*.java" -print -quit)" ]]; then
            echo "Xtend compilation of $name produced nothing; see $log" >&2
            exit 1
        fi

        mkdir -p "$BUILD/classes"
        # javac notes every deprecated and unchecked use of the generated Java,
        # which is not this script's business. Its exit status is, so the output
        # is filtered after the fact rather than through a pipe.
        # shellcheck disable=SC2046
        if ! javac -nowarn -proc:none -d "$BUILD/classes" \
            -cp "$BUILD/classes:$FULL_CP" $(find "$generated" -name "*.java") \
            > "$log.javac" 2>&1; then
            grep -E "error:|^[0-9]+ error" "$log.javac" || cat "$log.javac"
            echo "Java compilation of $name failed; see $log.javac" >&2
            exit 1
        fi
        rm -rf "$generated"
        echo "  $name compiled"
    done
fi

if [[ ! -d "$BUILD/classes" ]]; then
    echo "Nothing compiled yet; run without --no-build first." >&2
    exit 1
fi

# The working directory is the bundle, because without an Eclipse the technology
# models are read and copied relative to it.
cd "$BUNDLE"
exec java -cp "$BUILD/classes:$FULL_CP" \
    de.fhdo.lemma.reconstruction.cli.HeadlessReconstruction "${ARGS[@]}"
