FROM openjdk:11-alpine
ARG JAR_FILE=target/charging-station-management-command-side*.jar
COPY ${JAR_FILE} charging-station-management-command-side.jar
ENTRYPOINT ["java", "-jar", "/charging-station-management-command-side.jar"]
