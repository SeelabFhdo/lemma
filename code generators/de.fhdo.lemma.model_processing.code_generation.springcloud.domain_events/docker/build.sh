#!/usr/bin/env bash

# Use this script to build the Docker image for executing the Domain Events
# Genlet in Live Validation mode locally. The script can receive a single
# argument to identify the version of the Genlet to pass it to the Dockerfile.
# The current version of the Genlet may be found in the
#   "de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events/gradle.properties"
# file. In case no argument was passed, the script will rely on the
# LEMMA_VERSION environment variable to contain the version of the Genlet. To
# execute the Dockerfile successfully, the script requires the JAR of the Genlet
# to exist in the local filesystem.

export LEMMA_DOCKER_IMAGE_TAG="lemma/live_validation_client_domain_events:latest"

if [ ! -z "$1" ]; then
  LEMMA_VERSION="$1"
fi

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$LEMMA_VERSION" \
    -f Dockerfile \
    ../..