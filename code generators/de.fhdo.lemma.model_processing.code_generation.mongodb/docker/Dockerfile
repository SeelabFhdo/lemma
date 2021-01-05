FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.mongodb/target/de.fhdo.lemma.model_processing.code_generation.mongodb-$LEMMA_VERSION-standalone.jar \
    /home/mongodb.jar

ENTRYPOINT ["java", "-jar", "/home/mongodb.jar"]