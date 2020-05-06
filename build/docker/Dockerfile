FROM maven:3.6.3-openjdk-11-slim

# Point to Maven repository
COPY settings.xml /usr/share/maven/conf/

# Prepare Gradle. The gradle.properties is copied by the entrypoint to
# /root/.gradle. From there, Gradle will use it for all builds. If we would not
# rely on a dedicated gradle.properties file, we would have to pass the
# -Duser.home JVM parameter to all Gradle Wrapper calls.
RUN mkdir -p /usr/share/gradle/conf/
COPY gradle.properties /usr/share/gradle/conf/
ENV GRADLE_USER_HOME /root/.gradle

# Entrypoint
COPY docker-entrypoint.sh /usr/local/bin/
RUN ln -s /usr/local/bin/docker-entrypoint.sh /
ENTRYPOINT ["docker-entrypoint.sh"]

CMD ["mvn"]
