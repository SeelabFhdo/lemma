#!/bin/bash

# Create directories required by Maven and Gradle
mkdir -p /root/.m2
mkdir -p /root/.gradle
mkdir -p /root/.goomph

# The prepared "gradle.properties" file configures Gradle's user home, which
# needs to point to a writable directory shared between builds, i.e., /root
cp /usr/share/gradle/conf/gradle.properties /root/.gradle

# Delegate to default entrypoint
exec /usr/local/bin/mvn-entrypoint.sh "$@"
