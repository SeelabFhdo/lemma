#!/usr/bin/env bash

# Use this script to build the Java generator Docker image locally. The script
# expects a single argument, which identifies the version of the Java Base
# Generator to pass it to the Dockerfile. The current version of the generator
# may be found in the
#   "de.fhdo.lemma.model_processing.code_generation.java_base/gradle.properties"
# file. Furthermore, the script requires the JARs of the Java Base Generator and
# all of its Genlets to have been built locally.

export LEMMA_DOCKER_IMAGE_TAG="lemma/java_generator:latest"

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$1" \
    -f Dockerfile \
    ../..