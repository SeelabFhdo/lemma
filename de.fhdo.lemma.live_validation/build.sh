#!/usr/bin/env bash

if [[ -z "$JAVA_HOME" && (-f set_java_home.sh) ]];
then
    source set_java_home.sh
    sh set_java_home.sh && gradle fullBuild -Dorg.gradle.java.home="$JAVA_HOME"    
else
    gradle fullBuild
fi
