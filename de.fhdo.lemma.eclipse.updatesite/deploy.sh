#!/usr/bin/env bash

# This script controls the deployment of the LEMMA Eclipse Updatesite via SSH
# to a web server. The script expects the following environment variables to be
# set:
#   - DEPLOY_UPDATESITE_USER: User of the Updatesite web server.
#   - DEPLOY_UPDATESITE_PASSWORD: User password.
#   - DEPLOY_UPDATESITE_URL: URL of the Updatesite web server.
#   - DEPLOY_UPDATESITE_IP: IP of the Updatesite web server.

# Check if an environment variable exists and was set to some value
function check_env {
    if [[ ! -v $1 ]]; then
        echo "In order to run the script, you need to set the $1 variable"
        exit 1
    fi
}

# Deploy the Updatesite
function do_updatesite_deploy() {
    sshpass -p "$DEPLOY_UPDATESITE_PASSWORD" \
        scp -r -oStrictHostKeyChecking=no target/repository/* \
            "$DEPLOY_UPDATESITE_USER@$DEPLOY_UPDATESITE_IP":/var/www/lemma/
    rc=$?
    echo "Done (exit status was $rc)"
    return $rc
}

# Check if the current LEMMA revision has a release tag following the pattern
# v[major].[minor].[patch], with the [patch] part being optional
function revision_has_release_tag() {
    tag=$(git describe --exact-match --tags --abbrev=0 HEAD 2>/dev/null)
    rc=$?
    if [ $rc -eq 0 ]; then
        [[ $tag =~ ^v[0-9]+\.[0-9]+(\.[0-9]+)? ]] && return 0
    fi
    return 1
}

### MAIN SCRIPT

# Check environment variables
check_env DEPLOY_UPDATESITE_USER
check_env DEPLOY_UPDATESITE_PASSWORD
check_env DEPLOY_UPDATESITE_URL
check_env DEPLOY_UPDATESITE_IP

# Check if the Eclipse Updatesite was already deployed. If that is the case, we
# only do a re-deploy, if the current LEMMA revision has a release tag. If the
# Updatesite was not deployed so far, we do a re-deploy.
if curl --output /dev/null --silent --head --fail "$DEPLOY_UPDATESITE_URL/lemma/p2.index"; then
    if revision_has_release_tag; then
        echo "Revision has release tag. Deploying..."
        do_updatesite_deploy
    else
        echo "Revision has no release tag. Deployment not necessary."
    fi
else
    echo "Updatesite does not exist on server. Deploying..."
    do_updatesite_deploy
fi