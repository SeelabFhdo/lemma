#!/usr/bin/env bash

# This script builds LEMMA's offline documentation with Docker for the current
# LEMMA module

# Default documentation path when script is directly invoked by the user
DOCS_PATH="$(dirname $PWD)"

# Ensure Docker image exists and get image name
# (LEMMA_DOCUMENTATION_BUILDER_IMAGE environment variable). In case this script
# is invoked by the general build script for all documentations located in the
# ../../../build/documentation folder it will receive the path to the script for
# ensuring Docker image existence from the general build script.
ENSURE_DOCKER_IMAGE_SCRIPT="../../../build/documentation/ensure_docker_image.sh"
if [ ! -z "$1" ]; then
  ENSURE_DOCKER_IMAGE_SCRIPT="$1"
fi
source "$ENSURE_DOCKER_IMAGE_SCRIPT" "../../../build/documentation/docker"

# Determine the path of the documentation to build. In case this script is
# invoked by the general build script for all documentations located in the
# ../../../build/documentation folder it will receive the documentation path
# from the general build script.
if [ ! -z "$2" ]; then
  DOCS_PATH="$2"
fi

# Build documentation
docker run --rm \
    -v "$DOCS_PATH":/docs \
    -u $(id -u ${USER}):$(id -g ${USER}) \
    $LEMMA_DOCUMENTATION_BUILDER_IMAGE \
    make clean html