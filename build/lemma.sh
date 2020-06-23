#!/usr/bin/env bash

# This script controls LEMMA Jar builds under Linux and via the LEMMA Build
# Docker image. The script can be configured by means of an optional commandline
# argument that needs to point to a file with LEMMA build modules. If no
# argument is passed to the script, it will try to read the build modules from
# the "lemma-build-modules.txt" file located in the same folder as the script.

# Extract build modules from the passed module file. Lines starting with "#" and
# empty lines are ignored. All other lines are interpreted as LEMMA build
# modules.
extract_modules_from_file() {
    while read line || [ -n "$line" ];
    do
        if [[ -n "${line/[ ]*\n/}" ]] && ! [[ "$line" =~ ^[\s]*\#.* ]];
        then
            modulesToInclude+=("$line")
        fi
    done < $1
}

# Build a single module
do_build() {
    MODULE=$1
    echo -e "\033[1;35m------------------------------------------------------------------------"
    echo "Building module $MODULE ($2/$3)"
    echo -e "------------------------------------------------------------------------\033[0m"

    # Builds can be customized with a separate "build.sh" script in the modules'
    # root folders. Otherwise, Maven's "clean" and "install" tasks will be used
    # by default to build modules.
    if [ -f "$MODULE"/build.sh ]
    then
        buildCommand="cd '$MODULE' && bash build.sh && cd '$BUILD_ROOT'"
    else
        buildCommand="mvn -f '$MODULE'/pom.xml clean install"
    fi

    eval $buildCommand || { echo -e \
        "\033[0;31mBuild of $MODULE ($2/$3) unsuccessful\033[0m"; \
        notify_error "LEMMA Build Process Error: Build of $MODULE ($2/$3) unsuccessful!"; \
        exit 1; \
    }
    notify "LEMMA Build Process: $MODULE ($2/$3) successfully built"
}

# Send a notify message with notify-send if available
notify() {
    if hash notify-send 2>/dev/null; then
        notify-send "$1"
    fi
}

# Send a notify error message with notify-send if available
notify_error() {
    if hash notify-send 2>/dev/null; then
        notify-send -u critical "$1"
    fi
}

### MAIN SCRIPT

# Determine build module file
if ! [ -z "$1" ] && ! [ -f $1 ]
then
    echo "Module inclusion file \"$1\" does not exist. Exiting."
    exit 1
elif ! [ -z "$1" ]
then
    moduleInclusionFile=$1
else
    moduleInclusionFile=lemma-build-modules.txt
fi

# Extract build modules from file
modulesToInclude=()
extract_modules_from_file $moduleInclusionFile
MODULE_COUNT=${#modulesToInclude[@]}
CURRENT_MODULE_INDEX=1

# Run the actual builds
cd ..
BUILD_ROOT=$(pwd)

for module in "${modulesToInclude[@]}"; do
    do_build "$module" $CURRENT_MODULE_INDEX $MODULE_COUNT
    CURRENT_MODULE_INDEX=$((CURRENT_MODULE_INDEX+1))
done

notify "LEMMA Build Process: All modules built successfully!"
