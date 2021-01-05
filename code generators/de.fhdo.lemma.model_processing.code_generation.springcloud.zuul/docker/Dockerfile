FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud.zuul/target/de.fhdo.lemma.model_processing.code_generation.springcloud.zuul-$LEMMA_VERSION-standalone.jar \
    /home/zuul.jar

ENTRYPOINT ["java", "-jar", "/home/zuul.jar"]