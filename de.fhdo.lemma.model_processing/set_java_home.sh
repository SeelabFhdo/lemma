#!/usr/bin/env bash

# NOTE: The Live Validation Framework needs to be build with Java 9 or higher.
#       Set your JAVA_HOME environment variable, before you run the build in case
#       your default Java version is 8 or lower.
if [ -z "$JAVA_HOME" ]
then
    export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
fi
