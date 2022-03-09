#!/usr/bin/env bash

# Use this script to build the Live Validation server image locally. The script
# can receive a single argument to identify the version of the Live Validation
# server to pass it to the Dockerfile. The current version of the generator may
# be found in the "de.fhdo.lemma.live_validation/gradle.properties" file. In
# case no argument was passed, the script will rely on the LEMMA_VERSION
# environment variable to contain the version of the server. To execute the
# Dockerfile successfully, the script requires the JAR of the server to exist in
# the local filesystem.

export LEMMA_DOCKER_IMAGE_TAG="lemma/live_validation_server:latest"

if [ ! -z "$1" ]; then
  LEMMA_VERSION="$1"
fi

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$LEMMA_VERSION" \
    -f Dockerfile \
    ../..
