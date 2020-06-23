FROM maven:3.6.3-openjdk-11-slim
COPY --from=python:3.6.9 / /
RUN apt-get update && apt-get install -y sshpass

# Add settings.xml to point to Maven repository (cf. "../../docker/Dockerfile").
# To enable reuse of the settings.xml in "../../docker/", we expect the file's
# contents to be provided as a Docker build-arg
ARG MAVEN_SETTINGS_XML
RUN if [ "x$MAVEN_SETTINGS_XML" = "x" ]; \
    then echo "To build the image, "\
"you need to set the MAVEN_SETTINGS_XML Docker build-arg" && exit 1; \
fi

RUN echo "$MAVEN_SETTINGS_XML" > /usr/share/maven/conf/settings.xml

# Add Python script to adapt Maven's settings.xml to contain user and password
# for artifact deployment
RUN pip install lxml
COPY maven_settings_configurator.py /usr/share/maven/

# Prepare Gradle like in "../../docker/Dockerfile". To enable reuse of the
# gradle.properties in "../../docker/", we expect the file's contents to be
# provided as a Docker build-arg
ARG GRADLE_PROPERTIES
RUN if [ "x$GRADLE_PROPERTIES" = "x" ]; \
    then echo "To build the image, "\
"you need to set the GRADLE_PROPERTIES Docker build-arg" && exit 1; \
fi

RUN mkdir -p /usr/share/gradle/conf/
RUN echo "$GRADLE_PROPERTIES" > /usr/share/gradle/conf/gradle.properties
ENV GRADLE_USER_HOME /root/.gradle

# Entrypoint
COPY docker-entrypoint.sh /usr/local/bin/
RUN ln -s /usr/local/bin/docker-entrypoint.sh /
ENTRYPOINT ["docker-entrypoint.sh"]

CMD ["mvn"]