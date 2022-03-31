#!/bin/bash

JAVABASE_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.java_base/build/libs/de.fhdo.lemma.model_processing.code_generation.java_base-0.8.5-SNAPSHOT-standalone.jar"
SPRINGCLOUD_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.springcloud/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud-0.8.5-SNAPSHOT.jar"
SPRINGCLOUD_MTLS_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.springcloud.mtls/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.mtls-0.8.5-SNAPSHOT.jar"

TARGET_PATH="$HOME/masterthesis/lemmasecuritymodelgencode"
MODEL_PATH="$HOME/masterthesis/runtime-EclipseApplication/lemmasecuritymodel"

./gradlew clean build

echo "Java Base Generator - MS1"
java -jar "$JAVABASE_PATH" \
    -i "$MODEL_PATH/intermediate/service models/ms1.xmi" \
    -t "$TARGET_PATH" \
    --genlet "$SPRINGCLOUD_PATH" \
    --genlet "$SPRINGCLOUD_MTLS_PATH"


echo "Java Base Generator - MS2"
java -jar "$JAVABASE_PATH" \
    -i "$MODEL_PATH/intermediate/service models/ms2.xmi" \
    -t "$TARGET_PATH" \
    --genlet "$SPRINGCLOUD_PATH" \
    --genlet "$SPRINGCLOUD_MTLS_PATH"

