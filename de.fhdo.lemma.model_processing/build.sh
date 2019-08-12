#!/usr/bin/env bash

if [[ -z "$JAVA_HOME" && (-f set_java_home.sh) ]];
then
    source set_java_home.sh
    sh set_java_home.sh && gradle clean install -Dorg.gradle.java.home="$JAVA_HOME"    
else
    gradle clean install
fi
