#!/usr/bin/env bash

# Use this script to build the LEMMA2OpenAPI generator Docker image locally.
# The script can receive a single argument to identify the version of the
# generator to pass it to the Dockerfile. The current version of the generator
# may be found in the "../de.fhdo.lemma.service.openapi.parent/pom.xml" file.
# In case no argument was passed, the script will rely on the LEMMA_VERSION
# environment variable to contain the version of the generator. To execute the
# Dockerfile successfully, the script requires the standalone JAR of the
# LEMMA2OpenAPI generator to exist in the local filesystem.

export LEMMA_DOCKER_IMAGE_TAG="lemma/openapi_generator:latest"

if [ ! -z "$1" ]; then
  LEMMA_VERSION="$1"
fi

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$LEMMA_VERSION" \
    -f Dockerfile \
    ../..
