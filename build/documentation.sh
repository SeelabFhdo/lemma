#!/usr/bin/env bash

# This script builds LEMMA's offline documentations

# Documentation modules
modules=(
    de.fhdo.lemma.data.intermediate.metamodel
    de.fhdo.lemma.service.intermediate.metamodel
)

# Build a single documentation module
do_build() {
    MODULE=$1
    echo -e "\033[1;35m------------------------------------------------------------------------"
    echo "Building documentation $MODULE ($2/$3)"
    echo -e "------------------------------------------------------------------------\033[0m"
    make -C $MODULE/doc clean html || { echo -e \
        "\033[0;31mBuild of documentation $MODULE ($2/$3) unsuccessful\033[0m"; \
        notify_error "LEMMA Documentation Build Process Error: Build of documentation $MODULE ($2/$3) unsuccessful!"; \
        exit 1; \
    }
    notify "LEMMA Documentation Build Process: $MODULE ($2/$3) successfully built"
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

# Determine documentation build modules and count
MODULE_COUNT=$(wc -w <<< "${modules[@]}")
CURRENT_MODULE_INDEX=1

# Run the actual documentation builds
cd ..
for module in "${modules[@]}"; do
    do_build $module $CURRENT_MODULE_INDEX $MODULE_COUNT
    CURRENT_MODULE_INDEX=$((CURRENT_MODULE_INDEX+1))
done

notify "LEMMA Documentation Build Process: All modules built successfully!"
