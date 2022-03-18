plugins {
    base
    maven
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "de.fhdo.lemma.reconstruction.java.util"
            artifactId = "de.fhdo.lemma.reconstruction.java.util"
            version = version

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
            url = uri(
                if (version.toString().contains("-SNAPSHOT"))
                    snapshotsRepositoryUrl
                else
                    releasesRepositoryUrl
            )
        }
    }
}