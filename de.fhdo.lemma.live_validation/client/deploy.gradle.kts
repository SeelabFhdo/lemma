plugins {
    base
    maven
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "de.fhdo.lemma.live_validation"
            artifactId = "de.fhdo.lemma.live_validation.client"
            // Fetch version from environment variable because
            // Gradle does not propagate it from the root project
            version = System.getenv("LIVE_VALIDATION_VERSION")

            File("build/libs").listFiles().forEach {
                if (it.name.endsWith(".jar")) {
                    val extractedClassifier = it.name
                        .substringAfter(version)
                        .substringBefore(".jar")
                        .removePrefix("-")
                    if (extractedClassifier.isEmpty())
                        artifact(it)
                    else
                        artifact(it) {
                            classifier = extractedClassifier
                        }
                }
            }
        }
    }

    repositories {
        maven {
            credentials {
                username = System.getenv("DEPLOY_MAVEN_USER")
                password = System.getenv("DEPLOY_MAVEN_PASSWORD")
            }
            val snapshotsRepositoryUrl =
                System.getenv("DEPLOY_MAVEN_URL_SNAPSHOTS")
            val releasesRepositoryUrl =
                System.getenv("DEPLOY_MAVEN_URL_RELEASES")
            val isSnapshot = System.getenv("LIVE_VALIDATION_VERSION")
                .toString().contains("-SNAPSHOT")

            url = uri(
                if (isSnapshot)
                    snapshotsRepositoryUrl
                else
                    releasesRepositoryUrl
            )
        }
    }
}