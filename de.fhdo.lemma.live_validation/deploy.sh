#!/usr/bin/env bash

# Propagate version from root project via environment variable
export LIVE_VALIDATION_VERSION=$(python3 ../scripts/read_version_identifier_from_build_file.py gradle.properties)

./gradlew -b util/deploy.gradle.kts publish
./gradlew -b model/deploy.gradle.kts publish
./gradlew -b protocol/deploy.gradle.kts publish
./gradlew -b client/deploy.gradle.kts publish
./gradlew -b server/deploy.gradle.kts publish
