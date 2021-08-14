#!/usr/bin/env bash

# Propagate version from root project via environment variable
export LIVE_VALIDATION_VERSION=$(python3 ../scripts/read_version_identifier_from_build_file.py gradle.properties)

deploy_live_validation_artifact() {
  ARTIFACT_NAME=$1
  # Switch to sub-project directory as otherwise Gradle will search in the wrong "build/libs" directory when invoking
  # File("build/libs") within the "deploy.gradle.kts" specifications
  cd $ARTIFACT_NAME && ../gradlew -b deploy.gradle.kts publish && cd ..
}

deploy_live_validation_artifact "util"
deploy_live_validation_artifact "model"
deploy_live_validation_artifact "protocol"
deploy_live_validation_artifact "client"
deploy_live_validation_artifact "server"