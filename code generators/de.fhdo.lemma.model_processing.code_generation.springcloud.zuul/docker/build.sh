#!/usr/bin/env bash

# Use this script to build the Spring Cloud Zuul generator Docker image locally. The script
# expects a single argument, which identifies the version of the Spring Cloud Zuul
# Generator to pass it to the Dockerfile. The current version of the generator
# may be found in the
#   "de.fhdo.lemma.model_processing.code_generation.springcloud.zuul/pom.xml"
# file. Furthermore, the script requires the JARs of the Spring Cloud Zuul Generator.

export LEMMA_DOCKER_IMAGE_TAG="lemma/zuul_generator:latest"

docker build -t $LEMMA_DOCKER_IMAGE_TAG \
    --build-arg LEMMA_VERSION="$1" \
    -f Dockerfile \
    ../..