FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.java_base/build/libs/de.fhdo.lemma.model_processing.code_generation.java_base-$LEMMA_VERSION-standalone.jar \
    /home/java_base.jar

COPY de.fhdo.lemma.msa/target/de.fhdo.lemma.msa-$LEMMA_VERSION.jar /home/msa.jar
RUN mvn install:install-file \
    -Dfile=/home/msa.jar \
    -DgroupId=de.fhdo.lemma.msa \
    -DartifactId=de.fhdo.lemma.msa \
    -Dversion=$LEMMA_VERSION \
    -Dpackaging=jar

COPY \
    de.fhdo.lemma.model_processing.code_generation.ddd/build/libs/de.fhdo.lemma.model_processing.code_generation.ddd-$LEMMA_VERSION.jar \
    /home/genlets/de.fhdo.lemma.model_processing.code_generation.ddd.jar

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud-$LEMMA_VERSION.jar \
    /home/genlets/de.fhdo.lemma.model_processing.code_generation.springcloud.jar

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs-$LEMMA_VERSION.jar \
    /home/genlets/de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.jar

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events-$LEMMA_VERSION.jar \
    /home/genlets/de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.jar

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud.kafka/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.kafka-$LEMMA_VERSION.jar \
    /home/genlets/de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.jar

# "--add-opens java.base/java.lang=ALL-UNNAMED" prevents "WARNING: An illegal reflective access operation has occurred" until LEMMA is fully compatible with JPMS
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "/home/java_base.jar"]
