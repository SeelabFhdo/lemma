#!/usr/bin/env bash

# With the Gradle version used by the module it is currently required to set
# org.gradle.internal.publish.checksums.insecure to true, because the target
# repository does not support SHA-256 checksums for snapshot-maven-metadata.xml,
# yet. Without the flag set to true, the
# publishMavenPublicationToMavenRepository task will yield the following
# warning and no checksum will be published at all.
#       Cannot upload checksum for snapshot-maven-metadata.xml.
#       Remote repository doesn't support sha-256.
./gradlew -b deploy.gradle.kts \
    -Dorg.gradle.internal.publish.checksums.insecure=true \
    publish