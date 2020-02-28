#!/usr/bin/env bash

# The Gradle "clean" and "install" tasks need to be executed separatedly, 
# because of the com.diffplug.gradle.p2.asmaven plugin. Otherwise, the
# "extractEclipseDependencies" step will fail.


./gradlew clean && ./gradlew install
