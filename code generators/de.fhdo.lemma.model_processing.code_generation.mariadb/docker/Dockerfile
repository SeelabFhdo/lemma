FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.mariadb/target/de.fhdo.lemma.model_processing.code_generation.mariadb-$LEMMA_VERSION-standalone.jar \
    /home/mariadb.jar

ENTRYPOINT ["java", "-jar", "/home/mariadb.jar"]