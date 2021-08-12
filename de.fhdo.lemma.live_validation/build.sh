#!/usr/bin/env bash

if [ -f set_java_home.sh ];
then
    source set_java_home.sh
    # Don't execute ./gradlew in separate processes to ensure Gradle's adherence
    # to the build order of sub-projects
    sh set_java_home.sh && ./gradlew clean install -Dorg.gradle.java.home="$JAVA_HOME"
else
    # Don't execute ./gradlew in separate processes to ensure Gradle's adherence
    # to the build order of sub-projects
    ./gradlew clean install
fi