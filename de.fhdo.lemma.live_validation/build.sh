#!/usr/bin/env bash

if [ -f set_java_home.sh ];
then
    source set_java_home.sh
    sh set_java_home.sh && ./gradlew fullBuild -Dorg.gradle.java.home="$JAVA_HOME"    
else
    ./gradlew fullBuild 
fi
