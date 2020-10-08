pipeline {
    agent none

    environment {
        MATTERMOST_CHANNEL = credentials("lemma-builds-mattermost-channel")
        BASE_BRANCH_URL = "https://github.com/SeelabFhdo/lemma"

        DOCKER_NEXUS_REGISTRY_CREDENTIALS = "seelab-nexus-docker-registry"
        DOCKER_NEXUS_REGISTRY_URL = "http://repository.seelab.fh-dortmund.de:51900"
        DOCKER_RANCHER_REGISTRY_CREDENTIALS = "seelab-rancher-docker-registry"
        DOCKER_RANCHER_REGISTRY_URL = "http://registry.seelab.fh-dortmund.de"

        BUILD_IMAGE = "lemma/build:latest"
        BUILD_UPDATESITE_IMAGE = "lemma/updatesite:latest"

        DEPLOY_IMAGE = "lemma/deploy:latest"
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
                /*stage("Clean Workspace") {
                    steps {
                        cleanWs()
                    }
                }*/

                stage("Remove Build Management Folders") {
                    steps {
                        bat "${WINDOWS_RUN_GIT_COMMAND} \"cd \$HOME && " +
                            "rm -rf .m2/ && rm -rf .gradle/ && rm -rf .goomph\""
                    }
                }

                /*stage("Clone LEMMA") {
                    steps {
                        bat WINDOWS_RUN_GIT_COMMAND +
                            " \"git clone ${GIT_URL}\""
                        dir("lemma") {
                            bat WINDOWS_RUN_GIT_COMMAND +
                                " \"git checkout ${GIT_BRANCH}\""
                        }
                    }
                }*/

                stage("Build in Windows") {
                    steps {
                        dir("lemma/build") {
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
                    dir(".") {
                        script {
                            def postMessageBranchUrl = "${env.BASE_BRANCH_URL}/tree/${env.BRANCH_NAME}"
                            def postMessageBranch = env.BRANCH_NAME ? "\n\tBranch: <${postMessageBranchUrl}|${env.BRANCH_NAME}>" : ""
                            def postMessageCommitAuthor = bat(script: "${WINDOWS_RUN_GIT_COMMAND} \"git --no-pager show -s --format='%an'\"", returnStdout: true).trim()
                            def postMessageCommitMessage = bat(script: "${WINDOWS_RUN_GIT_COMMAND} \"git log --format=%B -n 1 ${GIT_COMMIT}\"", returnStdout: true).trim()
                            def postMessageCommitUrl = "${env.BASE_BRANCH_URL}/commit/${env.GIT_COMMIT}"
                            def postMessageCommitInfo = "(\"${postMessageCommitMessage}\") by *${postMessageCommitAuthor}*"
                            def postMessageCommit = env.GIT_COMMIT ? "\n\tCommit: <${postMessageCommitUrl}|${env.GIT_COMMIT}> ${postMessageCommitInfo}" : ""
                            def postMessageBody = "\n\tJob: ${env.JOB_NAME}" +
                                "${postMessageBranch}" +
                                "${postMessageCommit}" +
                                "\n\tStatus: ${currentBuild.result}" +
                                "\n\tBuild: <${env.BUILD_URL}|#${env.BUILD_NUMBER}>"

                            mattermostSend (
                                color: "danger",
                                message: "LEMMA Build FAILURE: ${postMessageBody}",
                                channel: MATTERMOST_CHANNEL
                            )
                        }
                    }
                }
            }
        }

        stage("Build and Deploy") {
            agent { label "master" }

            stages {
                /*stage("Clean Workspace") {
                    steps {
                        cleanWs()
                    }
                }*/

                /*stage("Clone LEMMA") {
                    steps {
                        dir("lemma") {
                            git url: GIT_URL, branch: GIT_BRANCH
                        }
                    }
                }*/

                stage("Build: Build and Push Docker Build Image") {
                    steps {
                        script {
                            buildImage = docker.build BUILD_IMAGE,
                                "./lemma/build/docker"
                            docker.withRegistry(DOCKER_NEXUS_REGISTRY_URL,
                                DOCKER_NEXUS_REGISTRY_CREDENTIALS) {
                                buildImage.push()
                            }
                            docker.withRegistry(DOCKER_RANCHER_REGISTRY_URL,
                                DOCKER_RANCHER_REGISTRY_CREDENTIALS) {
                                buildImage.push()
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
                        sh "cd lemma/build && ./lemma.sh"
                    }
                }

                stage("Eclipse Updatesite: Build and Push Docker Updatesite Image") {
                    steps {
                        script {
                            updatesiteImage = docker.build BUILD_UPDATESITE_IMAGE,
                                "./lemma/build/updatesite/docker"
                            docker.withRegistry(DOCKER_NEXUS_REGISTRY_URL,
                                DOCKER_NEXUS_REGISTRY_CREDENTIALS) {
                                updatesiteImage.push()
                            }
                            docker.withRegistry(DOCKER_RANCHER_REGISTRY_URL,
                                DOCKER_RANCHER_REGISTRY_CREDENTIALS) {
                                updatesiteImage.push()
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
                        sh "cd lemma/build/updatesite/ && ./lemma-updatesite.sh"
                    }
                }

                stage("Deployment: Build and Push Docker Deployment Image") {
                    steps {
                        script {
                            // We need to build the image in any case, otherwise the subsequent stage will fail,
                            // because the image doesn't exist
                            deployImage = docker.build(DEPLOY_IMAGE,
                                "--build-arg MAVEN_SETTINGS_XML=\"\$(cat ./lemma/build/docker/settings.xml)\" \
                                --build-arg GRADLE_PROPERTIES=\"\$(cat ./lemma/build/docker/gradle.properties)\" \
                                --build-arg JENKINS_UID=\"\$(id -u jenkins)\" \
                                ./lemma/build/deploy/docker"
                            )

                            if (env.BRANCH_NAME == 'master') {
                                docker.withRegistry(DOCKER_NEXUS_REGISTRY_URL,
                                    DOCKER_NEXUS_REGISTRY_CREDENTIALS) {
                                    deployImage.push()
                                }
                                docker.withRegistry(DOCKER_RANCHER_REGISTRY_URL,
                                    DOCKER_RANCHER_REGISTRY_CREDENTIALS) {
                                    deployImage.push()
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
                        branch 'master'
                    }

                    steps {
                        sh "cd lemma/build/deploy/ && ./lemma-deploy.sh /usr/share/maven/conf/settings.xml"
                    }
                }
            }

            post {
                success {
                    sh 'docker system prune -af --volumes'
                }

                always {
                    dir("lemma") {
                        script {
                            def postMessageBranchUrl = "${env.BASE_BRANCH_URL}/tree/${env.BRANCH_NAME}"
                            def postMessageBranch = env.BRANCH_NAME ? "\n\tBranch: <${postMessageBranchUrl}|${env.BRANCH_NAME}>" : ""
                            def postMessageCommitAuthor = sh(script: "git --no-pager show -s --format='%an'", returnStdout: true).trim()
                            def postMessageCommitMessage = sh(script: "git log --format=%B -n 1 ${GIT_COMMIT}", returnStdout: true).trim()
                            def postMessageCommitUrl = "${env.BASE_BRANCH_URL}/commit/${env.GIT_COMMIT}"
                            def postMessageCommitInfo = "(\"${postMessageCommitMessage}\") by *${postMessageCommitAuthor}*"
                            def postMessageCommit = env.GIT_COMMIT ? "\n\tCommit: <${postMessageCommitUrl}|${env.GIT_COMMIT}> ${postMessageCommitInfo}" : ""
                            def postMessageBody = "\n\tJob: ${env.JOB_NAME}" +
                                "${postMessageBranch}" +
                                "${postMessageCommit}" +
                                "\n\tStatus: ${currentBuild.result}" +
                                "\n\tBuild: <${env.BUILD_URL}|#${env.BUILD_NUMBER}>"

                            if(currentBuild.result != "FAILURE") {
                                mattermostSend (
                                    color: "good",
                                    message: "LEMMA Build SUCCESS: ${postMessageBody}",
                                    channel: MATTERMOST_CHANNEL
                                )

                                // Clean workspace upon success
                                cleanWs()
                            } else {
                                mattermostSend (
                                    color: "danger",
                                    message: "LEMMA Build FAILURE: ${postMessageBody}",
                                    channel: MATTERMOST_CHANNEL
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}