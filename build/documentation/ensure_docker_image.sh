#!/usr/bin/env bash

# Ensure that the image for building LEMMA's offline documentations with Docker
# exists

# Provide documentation build files with image name
LEMMA_DOCUMENTATION_BUILDER_IMAGE="lemma/documentation_builder:latest"

# Check if Docker image exists
exists_docker_image() {
    if [ ! -z $(docker images -q $LEMMA_DOCUMENTATION_BUILDER_IMAGE) ]
    then
        return 0
    else
        return 1
    fi
}

# Send a notify message with notify-send if available
notify() {
    if hash notify-send 2>/dev/null; then
        notify-send "$1"
    fi
}

# Send a notify error message with notify-send if available
notify_error() {
    if hash notify-send 2>/dev/null; then
        notify-send -u critical "$1"
    fi
}

### MAIN SCRIPT

# Build Docker image if it does not exist
if exists_docker_image ; then
    return
fi

# External invokers may pass a different folder for the Dockerfile
DOCKERFILE_FOLDER="docker"
if [ ! -z "$1" ]; then
  DOCKERFILE_FOLDER="$1"
fi

notify "LEMMA Documentation Build Process: Docker image $LEMMA_DOCUMENTATION_BUILDER_IMAGE does not exist. Building..."
echo -e "\033[1;35m------------------------------------------------------------------------"
echo "Building Docker image $LEMMA_DOCUMENTATION_BUILDER_IMAGE"
echo -e "------------------------------------------------------------------------\033[0m"
cd "$DOCKERFILE_FOLDER"
docker build -t $LEMMA_DOCUMENTATION_BUILDER_IMAGE . || { echo -e \
    "\033[0;31mBuild of Docker image $LEMMA_DOCUMENTATION_BUILDER_IMAGE unsuccessful\033[0m"; \
    notify_error "LEMMA Documentation Build Process Error: Build of Docker image $LEMMA_DOCUMENTATION_BUILDER_IMAGE unsuccessful!"; \
    exit 1; \
}
notify "LEMMA Documentation Build Process: Docker image $LEMMA_DOCUMENTATION_BUILDER_IMAGE successfully built"
cd ..