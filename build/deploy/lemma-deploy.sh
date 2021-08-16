#!/usr/bin/env bash

# This script controls the deployment of LEMMA modules under Linux and via the
# LEMMA Deploy Docker image. The script expects a commandline argument that
# points to a Maven "settings.xml" file, which stores the credentials of the
# servers to which the LEMMA modules shall be deployed by default (i.e., via
# Maven). Moreover, the script expects the following environment variables to
# be set:
#   - DEPLOY_MAVEN_ID_SNAPSHOTS: The ID of the snapshots server (must match the
#                                ID in the passed "settings.xml").
#   - DEPLOY_MAVEN_URL_SNAPSHOTS: The URL of the snapshots server.
#   - DEPLOY_MAVEN_ID_RELEASES: The ID of the releases server (must match the ID
#                               in the passed "settings.xml").
#   - DEPLOY_MAVEN_URL_RELEASES: The URL of the releases server.
# The script may also receive a second, optional commandline argument that needs
# to point to a file with LEMMA modules selected for deployment. If this
# argument is not passed to the script, it will try to read the deployment
# modules from the "lemma-deployment-modules.txt" file located in the same
# folder as the script.

# Extract build modules from the passed deployment file. Lines starting with "#"
# and empty lines are ignored. All other lines are interpreted as LEMMA
# deployment modules.
extract_modules_from_file() {
    while read line || [ -n "$line" ];
    do
        if [[ -n "${line/[ ]*\n/}" ]] && ! [[ "$line" =~ ^[\s]*\#.* ]];
        then
            modulesToInclude+=("$line")
        fi
    done < $1
}

# Deploy a single module
do_deploy() {
    MODULE=$1
    echo -e "\033[1;35m------------------------------------------------------------------------"
    echo "Deploying module $MODULE ($2/$3)"
    echo -e "------------------------------------------------------------------------\033[0m"

    # Deployments can be customized with a separate "deploy.sh" script in the
    # modules' root folders. Otherwise, Maven's "deploy:deploy-file" task will
    # be used by default to deploy modules.
    if [ -f "$MODULE"/deploy.sh ]
    then
        deployCommand="cd '$MODULE' && bash deploy.sh && cd '$DEPLOY_ROOT'"
    else
        deployCommand="do_maven_deploy '$MODULE'"
    fi

    eval $deployCommand || { echo -e \
        "\033[0;31mDeployment of $MODULE ($2/$3) unsuccessful\033[0m"; \
        notify_error "LEMMA Deployment Process Error: Deployment of $MODULE ($2/$3) unsuccessful!"; \
        exit 1; \
    }
    notify "LEMMA Deployment Process: $MODULE ($2/$3) successfully deployed"

    # Give deployment server a bit time to update
    if [ "$2" -lt "$3" ]; then
        countdown_to_next_deployment 5
    fi
}

# Deploy a single module via Maven
do_maven_deploy() {
    # Determine the module's "pom.xml" location
    MODULE=$1
    pomFile="$MODULE/pom.xml"
    if [ ! -f "$pomFile" ]
    then
        echo -e "\033[0;31mPOM file '$pomFile' does not exist!\033[0m";
        return 1
    fi

    # Distinguish between servers for Maven snapshot and release artifacts based
    # on the version identifier in the "pom.xml"
    if [ $(is_snapshot "$pomFile") ]
    then
        repositoryId=$DEPLOY_MAVEN_ID_SNAPSHOTS
        repositoryUrl=$DEPLOY_MAVEN_URL_SNAPSHOTS
    else
        repositoryId=$DEPLOY_MAVEN_ID_RELEASES
        repositoryUrl=$DEPLOY_MAVEN_URL_RELEASES
    fi

    # Do the actual deployment to the selected server and based on the
    # "settings.xml" file, whose path was passed to the script
    mvn deploy -f "$pomFile" \
        -DaltDeploymentRepository=$repositoryId::default::$repositoryUrl \
        -s $MAVEN_SETTINGS_FILEPATH
}

# Check if a "pom.xml" version represents a Maven snapshot
is_snapshot() {
    pomFile="$1"
    version=$(mvn -q -f "$pomFile" -Dexec.executable=echo \
        -Dexec.args='${project.version}' --non-recursive exec:exec)
    if [[ $version == *"-SNAPSHOT"* ]]; then
        echo 0
    else
        echo 1
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

# Wait and display countdown until next deployment
countdown_to_next_deployment() {
    secs=$1
    while [ $secs -gt 0 ]; do
        echo -ne "Countdown to deployment of next module: $secs\033[0K\r"
        sleep 1
        : $((secs--))
    done
}

### MAIN SCRIPT

# Tell Maven to use the "deployment" profile defined in the LEMMA modules' POM
# files. The profile skips tests, which are therefore not deployed either.
export LEMMA_DEPLOYMENT="true"

MAVEN_SETTINGS_FILEPATH=$1

# Determine deployment module file
if ! [ -z "$2" ] && ! [ -f $2 ]
then
    echo "Module inclusion file \"$2\" does not exist. Exiting."
    exit 1
elif ! [ -z "$2" ]
then
    moduleInclusionFile=$2
else
    moduleInclusionFile=lemma-deployment-modules.txt
fi

# Extract deployment modules from file
modulesToInclude=()
extract_modules_from_file $moduleInclusionFile

# Run the actual builds
cd ../..
DEPLOY_ROOT=$(pwd)
MODULE_COUNT=${#modulesToInclude[@]}
## If there are modules to deploy, fetch tags of all git remotes so that they
## can be considered by module-specific deployment scripts. For example, the
## Updatesite deployment script (de.fhdo.lemma.eclipse.updatesite/deploy.sh)
## checks if the last pulled commit has a release tag and in that case deploys
## the Eclipse Updatesite on a web server.
if (( $MODULE_COUNT > 0 )); then
    git fetch --tags --all
fi

CURRENT_MODULE_INDEX=1
for module in "${modulesToInclude[@]}"; do
    do_deploy "$module" $CURRENT_MODULE_INDEX $MODULE_COUNT
    CURRENT_MODULE_INDEX=$((CURRENT_MODULE_INDEX+1))
done

notify "LEMMA Deployment Process: All modules deployed successfully!"