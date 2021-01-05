FROM maven:3.6.3-openjdk-11-slim
ARG LEMMA_VERSION

COPY \
    de.fhdo.lemma.model_processing.code_generation.springcloud.eureka/target/de.fhdo.lemma.model_processing.code_generation.springcloud.eureka-$LEMMA_VERSION-standalone.jar \
    /home/eureka.jar

ENTRYPOINT ["java", "-jar", "/home/eureka.jar"]