FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.deployment_base/target/de.fhdo.lemma.model_processing.code_generation.deployment_base-$LEMMA_VERSION-standalone.jar \
    /home/deployment_base.jar

# "--add-opens java.base/java.lang=ALL-UNNAMED" prevents "WARNING: An illegal reflective access operation has occurred" until LEMMA is fully compatible with JPMS
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "/home/deployment_base.jar"]