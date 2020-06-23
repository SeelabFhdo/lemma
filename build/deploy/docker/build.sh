#!/usr/bin/env bash

# Build file for the LEMMA Deploy Docker image. Expects the concrete name of the
# image as argument. The script also enables to reuse the "settings.xml" and
# "gradle.properties" files from the top-level LEMMA "build" folder by means of
# Docker build-args.

docker build -t $1 \
    --build-arg MAVEN_SETTINGS_XML="$(cat ../../docker/settings.xml)" \
    --build-arg GRADLE_PROPERTIES="$(cat ../../docker/gradle.properties)" .
