#!/usr/bin/env bash

# Use this script to build the static analyzer Docker image locally. The script
# expects a single argument, which identifies the version of LEMMA's Static
# Analyzer to pass it to the Dockerfile. The current version of the analyzer
# may be found in the "de.fhdo.lemma.analyzer/gradle.properties" file.

export LEMMA_DOCKER_IMAGE_TAG="lemma/static_analyzer:latest"

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$1" \
    -f Dockerfile \
    ..