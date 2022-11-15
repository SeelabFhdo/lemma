FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs-$LEMMA_VERSION-standalone.jar \
    /home/cqrs_genlet.jar

# "--add-opens java.base/java.lang=ALL-UNNAMED" prevents "WARNING: An illegal reflective access operation has occurred" until LEMMA is fully compatible with JPMS
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "/home/cqrs_genlet.jar", "live_validation"]
