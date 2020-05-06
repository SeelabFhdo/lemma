#!/bin/bash

mkdir -p /root/.m2
mkdir -p /root/.gradle
mkdir -p /root/.goomph

cp /usr/share/gradle/conf/gradle.properties /root/.gradle

exec /usr/local/bin/mvn-entrypoint.sh "$@"
