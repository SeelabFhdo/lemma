FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.container_base/target/de.fhdo.lemma.model_processing.code_generation.container_base-$LEMMA_VERSION-standalone.jar \
    /home/container_base.jar



ENTRYPOINT ["java", "-jar", "/home/container_base.jar"]