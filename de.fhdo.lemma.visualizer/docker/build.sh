#!/usr/bin/env bash

# Use this script to build the static analyzer Docker image locally. The script
# can receive a single argument to identify the version of the static analyzer
# to pass it to the Dockerfile. The current version of the analyzer may be found
# may be found in the "de.fhdo.lemma.analyzer/gradle.properties" file. In case
# no argument was passed, the script will rely on the LEMMA_VERSION environment
# variable to contain the version of the analyzer.

export LEMMA_DOCKER_IMAGE_TAG="lemma/visualizer:latest"

if [ ! -z "$1" ]; then
  LEMMA_VERSION="$1"
fi

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$LEMMA_VERSION" \
    -f Dockerfile \
    ..