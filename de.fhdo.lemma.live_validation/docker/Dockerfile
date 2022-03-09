FROM openjdk:11-jre-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.live_validation/server/build/libs/de.fhdo.lemma.live_validation.server-$LEMMA_VERSION-runnable.jar \
    /home/live_validation_server.jar

ENTRYPOINT ["java", "-jar", "/home/live_validation_server.jar"]
