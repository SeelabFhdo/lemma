FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY build/libs/de.fhdo.lemma.analyzer-$LEMMA_VERSION-standalone.jar \
    /home/analyzer.jar

ENTRYPOINT ["java", "-jar", "/home/analyzer.jar"]