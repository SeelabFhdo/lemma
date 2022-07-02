FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION
#de.fhdo.lemma.model_processing.code_generation.keycloak.operation/build/libs/de.fhdo.lemma.model_processing.code_generation.keycloak.operations-$LEMMA_VERSION-standalone.jar \
COPY \
    de.fhdo.lemma.model_processing.code_generation.keycloak.operation/target/de.fhdo.lemma.model_processing.code_generation.keycloak.operations-$LEMMA_VERSION-jar-with-dependencies.jar \
    /home/container_base.jar

# "--add-opens java.base/java.lang=ALL-UNNAMED" prevents "WARNING: An illegal reflective access operation has occurred" until LEMMA is fully compatible with JPMS
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "/home/container_base.jar"]