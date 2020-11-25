#!/usr/bin/env bash

# This script builds and publishes Docker images for LEMMA modules, e.g.,
# standalone code generators. To participate in this process, LEMMA modules must
# comprise a sub-folder called "docker" in their source code root folders. This
# sub-folder must further contain a bash script called "build.sh".
#
# The present "docker-images-push" script will invoke a module's
# "docker/build.sh" script and pass to it the version of the LEMMA module. To
# determine the version of the LEMMA module, the "docker-images-push" script
# leverages the "read_version_identifier_from_build_file.py" Python script,
# which can parse Gradle as well as Maven version identifier files.
#
# The "docker-images-push" script expects the invoked "docker/build.sh" script
# to build a Docker image for its LEMMA module. Furthermore, the invoked
# "docker/build.sh" script must export an environment variable called
# LEMMA_DOCKER_IMAGE_TAG. The "docker-images-push" script will interpret the
# contents of this variable to represent the tag of the built Docker image and
# use it to publish the image to various registries. In case the invoked script
# does not export the variable, the "docker-images-push" script will exit with
# an error code.

# The "docker-images-push" script may receive the following CLI arguments:
#   - Unnamed first argument: Path to the file of relevant LEMMA modules. By
#                             default, the script will assume the module file
#                             "lemma-build-modules.txt" from LEMMA's build root.
#
#   - registry, user, password tuples: These tuples determine the registries to
#                                      publish built Docker images to. The
#                                      script expects them in the following
#                                      form and after a possible LEMMA module
#                                      file:
#       registry='registry1' user='registry1User' password='registry1Password' \
#       registry='registry2' user='registry2User' password='registry2Password' \
#       ...
#                                      In case no registry tuples are provided,
#                                      the script will only build the images and
#                                      not publish them.

declare -A registryUsers
declare -A registryPasswords

# Extract relevant LEMMA modules from the passed module file. Lines starting
# with "#" and empty lines are ignored. All other lines are interpreted as LEMMA
# modules for Docker image building and publishing.
extract_modules_from_file() {
    while read line || [ -n "$line" ];
    do
        if [[ -n "${line/[ ]*\n/}" ]] && ! [[ "$line" =~ ^[\s]*\#.* ]];
        then
            modulesToInclude+=("$line")
        fi
    done < $1
}

# Check if a LEMMA module contains a "docker/build.sh" script
is_for_docker_push() {
    module=$1
    if [ -f "$module/docker/build.sh" ]
    then
        return 0
    else
        return 1
    fi
}

# Build and publish the Docker image of a LEMMA module
do_image_build_and_push() {
    module=$1
    echo -e "\033[1;35m------------------------------------------------------------------------"
    echo "Docker image build and push of module $module"
    echo -e "------------------------------------------------------------------------\033[0m"
    do_image_build "$module"

    if [ "${#registryUsers[@]}" -ne 0 ]; then
        do_image_push "$module" $LEMMA_DOCKER_IMAGE_TAG
        unset LEMMA_DOCKER_IMAGE_TAG
    fi
}

# Build the image of a given module
do_image_build() {
    module=$1
    versionIdentifier=$(read_version_identifier "$module")

    cd "$module/docker"

    # We source here, to retrieve the LEMMA_DOCKER_IMAGE_TAG environment
    # variable AND also execute the "docker/build.sh" script
    source ./build.sh $versionIdentifier
    if [ -z "$LEMMA_DOCKER_IMAGE_TAG" ]
    then
        echo -e "\033[0;31mBuild script of module \"$module\" did not set" \
            "environment variable \"\$LEMMA_DOCKER_IMAGE_TAG\" for Docker" \
            "image tag"
        exit 1
    fi

    cd $BUILD_ROOT
}

# Read the version identifier of a LEMMA Gradle or Maven module
read_version_identifier() {
    module=$1
    if [ -f "$module/gradle.properties" ]
    then
        versionFile="gradle.properties"
    elif [ -f "$module/pom.xml" ]
    then
        versionFile="pom.xml"
    else
        echo -e "\033[0;31mCannot determine version identifier file for" \
            "module \"$module\"\033[0m"
        exit 1
    fi

    versionFileFullPath="$BUILD_ROOT/$module/$versionFile"
    version=$(python3 $SCRIPT_ROOT/read_version_identifier_from_build_file.py \
        "$versionFileFullPath" 2>&1)
    if [ $? -eq 1 ]
    then
        echo -e "\033[0;31mError while version identifier parsing:" \
            "$version\033[0m"
        exit 1
    fi

    echo $version
}

# Push a module's image with the given tag to all relevant registries
do_image_push() {
    module=$1
    tag=$2
    for R in "${!registryUsers[@]}"
    do
        registry=$R
        user=${registryUsers[$R]}
        password=${registryPasswords[$R]}
        echo "$password" | docker login --username "$user" --password-stdin "https://$registry"
        registryTag="$registry/$tag"
        docker image tag $tag $registryTag
        docker push $registryTag
        docker logout $registry
    done
}

### MAIN SCRIPT

# Determine file of relevant LEMMA modules
if ! [[ "$1" == *"="* ]]
then
    if ! [ -z "$1" ] && ! [ -f $1 ]
    then
        echo "Module inclusion file \"$1\" does not exist. Exiting."
        exit 1
    elif ! [ -z "$1" ]
    then
        moduleInclusionFile=$1
    fi
fi

if [ -z "$moduleInclusionFile" ]
then
    moduleInclusionFile=../lemma-build-modules.txt
fi

# Setup associative array for Docker registry users and passwords
for argument in "$@"
do
    key=$(echo $argument | cut -f1 -d=)
    value=$(echo $argument | cut -f2 -d=)

    case "$key" in
        registry)
            registryHost=$(echo $value | sed -E -e "s=^(https|http)://==")
            current_registry=$registryHost ;;
        user)
            registryUsers[$current_registry]=$value ;;
        password)
            registryPasswords[$current_registry]=$value ;;
        *)
    esac
done

# Extract relevant LEMMA modules from file
modulesToInclude=()
extract_modules_from_file $moduleInclusionFile

# Perform the actual image builds and publications
SCRIPT_ROOT=$(pwd)
cd ../..
BUILD_ROOT=$(pwd)

for module in "${modulesToInclude[@]}"; do
    if is_for_docker_push "$module"; then
        do_image_build_and_push "$module"
    fi
done

echo -e '\033[1;35mLEMMA Docker Image Build and Push Process: All module' \
    'images built and pushed successfully!\033[0m'