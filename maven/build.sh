#!/usr/bin/env bash

do_build() {    
    MODULE=$1
    echo -e "\033[1;35m------------------------------------------------------------------------"
    echo "Building module $MODULE"
    echo -e "------------------------------------------------------------------------\033[0m"
    mvn -f $MODULE/pom.xml clean install || { echo -e "\033[0;31mBuild of $MODULE unsuccessful\033[0m"; exit 1; }
}

cd ..

# Utils
do_build    DdmmUiUtils
do_build    DataViewpointModel
do_build    DdmmUtils

# Type Checker
do_build    TechnologyDefinitionModel
do_build    DdmmTypechecking

# Languages
do_build    de.fhdo.ddmm.data.datadsl.parent
do_build    de.fhdo.ddmm.technology.technologydsl.parent
do_build    de.fhdo.ddmm.servicedsl.parent
do_build    de.fhdo.ddmm.technology.mappingdsl.parent
do_build    de.fhdo.ddmm.operationdsl.parent

# Transformations
do_build    IntermediateModelTransformations.parent

# UI Components
do_build    de.fhdo.ddmm.eclipse.ui.parent
