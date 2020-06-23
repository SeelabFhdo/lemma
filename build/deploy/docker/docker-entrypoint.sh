#!/bin/bash

# Check if an environment variable exists and was set to some value
function check_env {
    if [[ ! -v $1 ]]; then
        echo "In order to run the container you need to set the $1 variable"
        exit 1
    fi
}

### MAIN SCRIPT

# Expected environment variables for Maven-based deployments
check_env DEPLOY_MAVEN_USER  # Deployment user
check_env DEPLOY_MAVEN_PASSWORD  # User password
# ID for the Maven snapshots server (this can be an arbitrary value that must
# conform to what Maven expects from an ID in a "settings.xml" file)
check_env DEPLOY_MAVEN_ID_SNAPSHOTS
check_env DEPLOY_MAVEN_URL_SNAPSHOTS  # URL of the snapshots server
check_env DEPLOY_MAVEN_ID_RELEASES  # ID of the releases server (see above)
check_env DEPLOY_MAVEN_URL_RELEASES  # URL of the releases server

# Expected environment variables for Eclipse Updatesite deployment
check_env DEPLOY_UPDATESITE_USER  # User for the Updatesite server
check_env DEPLOY_UPDATESITE_PASSWORD  # User password
check_env DEPLOY_UPDATESITE_URL  # URL of the Updatesite server
check_env DEPLOY_UPDATESITE_IP  # IP of the Updatesite server

# Create directories required by Maven and Gradle
mkdir -p /root/.m2
mkdir -p /root/.gradle
mkdir -p /root/.goomph

# The prepared "gradle.properties" file configures Gradle's user home, which
# needs to point to a writable directory shared between builds, i.e., /root
cp /usr/share/gradle/conf/gradle.properties /root/.gradle

# Execute helper Python script to prepare the Maven "settings.xml" for
# deployments
python3 /usr/share/maven/maven_settings_configurator.py \
    /usr/share/maven/conf/settings.xml
rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi

# Delegate to default entrypoint
exec /usr/local/bin/mvn-entrypoint.sh "$@"
