FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY build/libs/de.fhdo.lemma.analyzer-$LEMMA_VERSION-standalone.jar \
    /home/analyzer.jar

# "--add-opens java.base/java.lang=ALL-UNNAMED" prevents "WARNING: An illegal reflective access operation has occurred" until LEMMA is fully compatible with JPMS
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "/home/analyzer.jar"]