pipeline {
    agent none

    environment {
        BASE_BRANCH_URL = "https://github.com/SeelabFhdo/lemma"
        DISCORD_WEBHOOK = credentials("lemma-builds-discord-webhook-url")

        LEMMA_LOCAL_DOCKER_REPO = "lemma"
        LEMMA_DOCKER_HUB_REPO = "lemmahub"

        DOCKER_HUB_REGISTRY_CREDENTIALS_KEY = "lemma-dockerhub-registry"
        DOCKER_HUB_REGISTRY_CREDENTIALS = credentials("$DOCKER_HUB_REGISTRY_CREDENTIALS_KEY")
        DOCKER_HUB_REGISTRY_REPOSITORY = "${LEMMA_DOCKER_HUB_REPO}"
        DOCKER_HUB_REGISTRY_URL = "https://registry.hub.docker.com"
        DOCKER_NEXUS_REGISTRY_CREDENTIALS_KEY = "seelab-nexus-docker-registry"
        DOCKER_NEXUS_REGISTRY_CREDENTIALS = credentials("$DOCKER_NEXUS_REGISTRY_CREDENTIALS_KEY")
        DOCKER_NEXUS_REGISTRY_URL = "https://docker.repository.seelab.fh-dortmund.de"

        BUILD_IMAGE_NAME = "build:latest"
        BUILD_IMAGE = "${LEMMA_LOCAL_DOCKER_REPO}/${BUILD_IMAGE_NAME}"
        BUILD_IMAGE_DOCKER_HUB = "${LEMMA_DOCKER_HUB_REPO}/${BUILD_IMAGE_NAME}"

        BUILD_UPDATESITE_IMAGE_NAME = "updatesite:latest"
        BUILD_UPDATESITE_IMAGE = "${LEMMA_LOCAL_DOCKER_REPO}/${BUILD_UPDATESITE_IMAGE_NAME}"
        BUILD_UPDATESITE_IMAGE_DOCKER_HUB = "${LEMMA_DOCKER_HUB_REPO}/${BUILD_UPDATESITE_IMAGE_NAME}"

        DEPLOY_IMAGE_NAME = "deploy:latest"
        DEPLOY_IMAGE = "${LEMMA_LOCAL_DOCKER_REPO}/${DEPLOY_IMAGE_NAME}"
        DEPLOY_IMAGE_DOCKER_HUB = "${LEMMA_DOCKER_HUB_REPO}/${DEPLOY_IMAGE_NAME}"
        DEPLOY_MAVEN_REPOSITORY_CREDENTIALS = credentials("seelab-nexus-maven-repository")
        DEPLOY_MAVEN_SNAPSHOTS_ID = "nexus-snapshots"
        DEPLOY_MAVEN_SNAPSHOTS_URL = "https://repository.seelab.fh-dortmund.de/repository/maven-snapshots/"
        DEPLOY_MAVEN_RELEASES_ID = "nexus-releases"
        DEPLOY_MAVEN_RELEASES_URL = "https://repository.seelab.fh-dortmund.de/repository/maven-releases/"
        DEPLOY_UPDATESITE_CREDENTIALS = credentials("lemma-eclipse-updatesite")
        DEPLOY_UPDATESITE_URL = credentials("lemma-eclipse-updatesite-url")
        DEPLOY_UPDATESITE_IP = credentials("lemma-eclipse-updatesite-ip")

        WINDOWS_GIT = "\"%ProgramFiles%\\Git\\git-bash.exe\""
        WINDOWS_JAVA_VERSION = "jdk-11.0.2"
        WINDOWS_RUN_GIT_COMMAND = "start /wait \"\" ${WINDOWS_GIT} -c"
    }

    stages {
        stage("Windows Build") {
            agent { label "windows" }

            stages {
                stage("Remove Build Management Folders") {
                    steps {
                        bat "${WINDOWS_RUN_GIT_COMMAND} \"cd \$HOME && " +
                            "rm -rf .m2/ && rm -rf .gradle/ && rm -rf .goomph\""
                    }
                }

                stage("Build in Windows") {
                    steps {
                        dir("build") {
                            script {
                                env.JAVA_HOME="${env.ProgramFiles}\\" +
                                    WINDOWS_JAVA_VERSION
                            }
                            bat "call lemma.bat"
                            script {
                                env.JAVA_HOME=""
                            }
                        }
                    }
                }
            }

            post {
                success {
                    cleanWs()
                }

                failure {
                    script {
                        def postMessageBranchUrl = "${env.BASE_BRANCH_URL}/tree/${env.BRANCH_NAME}"
                        def postMessageBranch = env.BRANCH_NAME ? "\n\tBranch: [${env.BRANCH_NAME}](${postMessageBranchUrl})" : ""

                        def postMessageCommitAuthor = bat(
                                script: "${WINDOWS_RUN_GIT_COMMAND} \"git --no-pager show -s --format='%%an' > __windows_out\" && type __windows_out && del __windows_out",
                                returnStdout: true
                            ).trim()
                        postMessageCommitAuthor = postMessageCommitAuthor.readLines().drop(1).join(" ")

                        def postMessageCommitMessage = bat(
                                script: "${WINDOWS_RUN_GIT_COMMAND} \"git log --format=%%B -n 1 ${GIT_COMMIT} > __windows_out\" && type __windows_out && del __windows_out",
                                returnStdout: true
                            ).trim()
                        postMessageCommitMessage = postMessageCommitMessage.readLines().drop(1).join(" ")

                        def postMessageCommitUrl = "${env.BASE_BRANCH_URL}/commit/${env.GIT_COMMIT}"
                        def postMessageCommitInfo = "(\"${postMessageCommitMessage}\") by *${postMessageCommitAuthor}*"
                        def postMessageCommit = env.GIT_COMMIT ? "\n\tCommit: [${env.GIT_COMMIT}](${postMessageCommitUrl}) ${postMessageCommitInfo}" : ""
                        def postMessageBody = "\n\tJob: ${env.JOB_NAME}" +
                            "${postMessageBranch}" +
                            "${postMessageCommit}" +
                            "\n\tStatus: ${currentBuild.result}" +
                            "\n\tBuild: [#${env.BUILD_NUMBER}](${env.BUILD_URL})"

                        discordSend(
                            result: currentBuild.currentResult,
                            description: "LEMMA Build ${currentBuild.result}: ${postMessageBody}",
                            webhookURL: DISCORD_WEBHOOK
                        )
                    }
                }
            }
        }

        stage("Build and Deploy") {
            agent { label "controller" }

            stages {
                stage("Build: Build and Push Docker Build Image") {
                    steps {
                        script {
                            buildImage = docker.build BUILD_IMAGE,
                                "./build/docker"
                            docker.withRegistry(DOCKER_NEXUS_REGISTRY_URL,
                                DOCKER_NEXUS_REGISTRY_CREDENTIALS_KEY) {
                                buildImage.push()
                            }

                            buildImageDockerHub = docker.build BUILD_IMAGE_DOCKER_HUB,
                                "./build/docker"
                            docker.withRegistry(DOCKER_HUB_REGISTRY_URL,
                                DOCKER_HUB_REGISTRY_CREDENTIALS_KEY) {
                                buildImageDockerHub.push()
                            }
                        }
                    }
                }

                stage("Build: Build in Docker Build Image") {
                    agent {
                        docker {
                            image BUILD_IMAGE
                            args "-v ${env.WORKSPACE}:/root"
                            reuseNode true
                        }
                    }
                    steps {
                        sh "cd build && ./lemma.sh"
                    }
                }

                stage("Eclipse Updatesite: Build and Push Docker Updatesite Image") {
                    steps {
                        script {
                            updatesiteImage = docker.build BUILD_UPDATESITE_IMAGE,
                                "./build/updatesite/docker"
                            docker.withRegistry(DOCKER_NEXUS_REGISTRY_URL,
                                DOCKER_NEXUS_REGISTRY_CREDENTIALS_KEY) {
                                updatesiteImage.push()
                            }

                            updatesiteImageDockerHub = docker.build BUILD_UPDATESITE_IMAGE_DOCKER_HUB,
                                "./build/updatesite/docker"
                            docker.withRegistry(DOCKER_HUB_REGISTRY_URL,
                                DOCKER_HUB_REGISTRY_CREDENTIALS_KEY) {
                                updatesiteImageDockerHub.push()
                            }
                        }
                    }
                }

                stage("Eclipse Updatesite: Build in Docker Updatesite Image") {
                    agent {
                        docker {
                            image BUILD_UPDATESITE_IMAGE
                            args "-v ${env.WORKSPACE}:/root"
                            reuseNode true
                        }
                    }
                    steps {
                        sh "cd build/updatesite/ && ./lemma-updatesite.sh"
                    }
                }

                stage("Deployment: Build and Push Docker Deployment Image") {
                    steps {
                        script {
                            // We need to build the image in any case, otherwise the subsequent stage will fail,
                            // because the image doesn't exist
                            deployImage = docker.build(DEPLOY_IMAGE,
                                "--build-arg MAVEN_SETTINGS_XML=\"\$(cat ./build/docker/settings.xml)\" \
                                --build-arg GRADLE_PROPERTIES=\"\$(cat ./build/docker/gradle.properties)\" \
                                --build-arg JENKINS_UID=\"\$(id -u jenkins)\" \
                                ./build/deploy/docker"
                            )

                            if (env.BRANCH_NAME == 'main') {
                                docker.withRegistry(DOCKER_NEXUS_REGISTRY_URL,
                                    DOCKER_NEXUS_REGISTRY_CREDENTIALS_KEY) {
                                    deployImage.push()
                                }

                                deployImageDockerHub = docker.build(DEPLOY_IMAGE_DOCKER_HUB,
                                    "--build-arg MAVEN_SETTINGS_XML=\"\$(cat ./build/docker/settings.xml)\" \
                                    --build-arg GRADLE_PROPERTIES=\"\$(cat ./build/docker/gradle.properties)\" \
                                    --build-arg JENKINS_UID=\"\$(id -u jenkins)\" \
                                    ./build/deploy/docker"
                                )
                                docker.withRegistry(DOCKER_HUB_REGISTRY_URL,
                                    DOCKER_HUB_REGISTRY_CREDENTIALS_KEY) {
                                    deployImageDockerHub.push()
                                }
                            }
                        }
                    }
                }

                stage("Deployment: Deployment via Docker Deployment Image") {
                    agent {
                        docker {
                            image DEPLOY_IMAGE
                            args "-v ${env.WORKSPACE}:/root\
                            -e DEPLOY_MAVEN_USER=$DEPLOY_MAVEN_REPOSITORY_CREDENTIALS_USR\
                            -e DEPLOY_MAVEN_PASSWORD=$DEPLOY_MAVEN_REPOSITORY_CREDENTIALS_PSW\
                            -e DEPLOY_MAVEN_ID_SNAPSHOTS=$DEPLOY_MAVEN_SNAPSHOTS_ID\
                            -e DEPLOY_MAVEN_URL_SNAPSHOTS=$DEPLOY_MAVEN_SNAPSHOTS_URL\
                            -e DEPLOY_MAVEN_ID_RELEASES=$DEPLOY_MAVEN_RELEASES_ID\
                            -e DEPLOY_MAVEN_URL_RELEASES=$DEPLOY_MAVEN_RELEASES_URL\
                            -e DEPLOY_UPDATESITE_USER=$DEPLOY_UPDATESITE_CREDENTIALS_USR\
                            -e DEPLOY_UPDATESITE_PASSWORD=$DEPLOY_UPDATESITE_CREDENTIALS_PSW\
                            -e DEPLOY_UPDATESITE_URL=$DEPLOY_UPDATESITE_URL\
                            -e DEPLOY_UPDATESITE_IP=$DEPLOY_UPDATESITE_IP"
                            reuseNode true
                        }
                    }

                    when {
                        branch 'main'
                    }

                    steps {
                        sh "cd build/deploy/ && ./lemma-deploy.sh /usr/share/maven/conf/settings.xml"
                    }
                }

                stage("Docker: Build and Publish Docker Images") {
                    steps {
                        script {
                            if (env.BRANCH_NAME == 'main') {
                                def publishArgs =
                                    "registry=\'$DOCKER_NEXUS_REGISTRY_URL\' " +
                                    "user=\'$DOCKER_NEXUS_REGISTRY_CREDENTIALS_USR\' " +
                                    "password=\'$DOCKER_NEXUS_REGISTRY_CREDENTIALS_PSW\' " +
                                    "registry=\'$DOCKER_HUB_REGISTRY_URL\' " +
                                    "user=\'$DOCKER_HUB_REGISTRY_CREDENTIALS_USR\' " +
                                    "password=\'$DOCKER_HUB_REGISTRY_CREDENTIALS_PSW\' " +
                                    "repository=\'$DOCKER_HUB_REGISTRY_REPOSITORY\' "
                                sh "cd build/docker-images-push && ./docker-images-push.sh $publishArgs"
                            } else
                                sh "cd build/docker-images-push && ./docker-images-push.sh"
                        }
                    }
                }
            }

            post {
                always {
                    script {
                        def postMessageBranchUrl = "${env.BASE_BRANCH_URL}/tree/${env.BRANCH_NAME}"
                        def postMessageBranch = env.BRANCH_NAME ? "\n\tBranch: [${env.BRANCH_NAME}](${postMessageBranchUrl})" : ""
                        def postMessageCommitAuthor = sh(script: "git --no-pager show -s --format='%an'", returnStdout: true).trim()
                        def postMessageCommitMessage = sh(script: "git log --format=%B -n 1 ${GIT_COMMIT}", returnStdout: true).trim()
                        def postMessageCommitUrl = "${env.BASE_BRANCH_URL}/commit/${env.GIT_COMMIT}"
                        def postMessageCommitInfo = "(\"${postMessageCommitMessage}\") by *${postMessageCommitAuthor}*"
                        def postMessageCommit = env.GIT_COMMIT ? "\n\tCommit: [${env.GIT_COMMIT}](${postMessageCommitUrl}) ${postMessageCommitInfo}" : ""
                        def postMessageBody = "\n\tJob: ${env.JOB_NAME}" +
                            "${postMessageBranch}" +
                            "${postMessageCommit}" +
                            "\n\tStatus: ${currentBuild.result}" +
                            "\n\tBuild: [#${env.BUILD_NUMBER}](${env.BUILD_URL})"

                        discordSend(
                            result: currentBuild.currentResult,
                            description: "LEMMA Build ${currentBuild.result}: ${postMessageBody}",
                            webhookURL: DISCORD_WEBHOOK
                        )

                        // Clean workspace upon success
                        if(currentBuild.result != "FAILURE") {
                            cleanWs()
                        }
                    }
                }
            }
        }
    }
}