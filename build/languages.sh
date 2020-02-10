#!/usr/bin/env bash

modules=(
    # Utils
    de.fhdo.lemma.eclipse.ui.utils
    de.fhdo.lemma.data.datadsl.metamodel
    de.fhdo.lemma.utils

    # Type Checker
    de.fhdo.lemma.technology.technologydsl.metamodel
    de.fhdo.lemma.typechecking

    # Languages
    de.fhdo.lemma.data.datadsl.parent
    de.fhdo.lemma.technology.technologydsl.parent
    de.fhdo.lemma.servicedsl.parent
    de.fhdo.lemma.technology.mappingdsl.parent
    de.fhdo.lemma.operationdsl.parent

    # Transformations
    de.fhdo.lemma.intermediate.transformations.parent

    # Live Validation Framework
    de.fhdo.lemma.live_validation

    # UI Components
    de.fhdo.lemma.eclipse.ui.parent

    # OCL
    de.fhdo.lemma.ocl

    # Model Processing Framework
    de.fhdo.lemma.model_processing
)

do_build() {
    MODULE=$1
    echo -e "\033[1;35m------------------------------------------------------------------------"
    echo "Building module $MODULE ($2/$3)"
    echo -e "------------------------------------------------------------------------\033[0m"

    # Builds can be customized with a separate "build.sh" script in the modules' root folders. 
    # Otherwise, Maven's "clean" and "install" tasks will be used by default to build modules.
    if [ -f $MODULE/build.sh ]
    then
        buildCommand="cd $MODULE && bash build.sh && cd .."
    else
        buildCommand="mvn -f $MODULE/pom.xml clean install"
    fi

    eval $buildCommand || { echo -e "\033[0;31mBuild of $MODULE ($2/$3) unsuccessful\033[0m"; notify_error "LEMMA Build Process Error: Build of $MODULE ($2/$3) unsuccessful!"; exit 1; }
    notify "LEMMA Build Process: $MODULE ($2/$3) successfully built"
}

notify() {
    if hash notify-send 2>/dev/null; then
        notify-send "$1"
    fi
}

notify_error() {
    if hash notify-send 2>/dev/null; then
        notify-send -u critical "$1"
    fi
}

cd ..

MODULE_COUNT=$(wc -w <<< "${modules[@]}")
CURRENT_MODULE_INDEX=1

for module in "${modules[@]}"; do
    do_build $module $CURRENT_MODULE_INDEX $MODULE_COUNT
    CURRENT_MODULE_INDEX=$((CURRENT_MODULE_INDEX+1))
done

notify "LEMMA Build Process: All modules built successfully!"
