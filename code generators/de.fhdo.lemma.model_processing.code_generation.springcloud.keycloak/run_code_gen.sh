#!/bin/bash

JAVABASE_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.java_base"
JAVABASE_GENERATOR="/build/libs/de.fhdo.lemma.model_processing.code_generation.java_base-0.8.5-SNAPSHOT-standalone.jar"
JAVABASE="$JAVABASE_PATH$JAVABASE_GENERATOR"

SPRINGCLOUD_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.springcloud"
SPRINGCLOUD_PATH_GENLET="/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud-0.8.5-SNAPSHOT.jar"
SPRINGCLOUD="$SPRINGCLOUD_PATH$SPRINGCLOUD_PATH_GENLET"

SPRINGCLOUD_MTLS_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.springcloud.mtls"
SPRINGCLOUD_MTLS_GENLET="/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.mtls-0.8.5-SNAPSHOT.jar"
SPRINGCLOUD_MTLS="$SPRINGCLOUD_MTLS_PATH$SPRINGCLOUD_MTLS_GENLET"

SPRINGCLOUD_KEYCLOAK_PATH="$HOME/masterthesis/eclipse-workspace/lemma/code generators/de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak"
SPRINGCLOUD_KEYCLOAK_GENLET="/build/libs/de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak-0.8.5-SNAPSHOT.jar"
SPRINGCLOUD_KEYCLOAK="$SPRINGCLOUD_KEYCLOAK_PATH$SPRINGCLOUD_KEYCLOAK_GENLET"

TARGET_PATH="$HOME/masterthesis/lemmasecuritymodelgencode"
MODEL_PATH="$HOME/masterthesis/runtime-EclipseApplication/lemmasecuritymodel"

#cd "$JAVABASE_PATH"
#./gradlew clean install
#cd "$SPRINGCLOUD_PATH"
#./gradlew clean install
cd "$SPRINGCLOUD_MTLS_PATH"
./gradlew clean install
cd "$SPRINGCLOUD_KEYCLOAK_PATH"
./gradlew clean install

echo "--------------------------Java Base Generator - MS1--------------------------"
java -jar "$JAVABASE" \
    -i "$MODEL_PATH/intermediate/service models/ms1.xmi" \
    -t "$TARGET_PATH" \
    --genlet "$SPRINGCLOUD" \
    --genlet "$SPRINGCLOUD_MTLS" \
    --genlet "$SPRINGCLOUD_KEYCLOAK"

echo "--------------------------Java Base Generator - MS2--------------------------"
java -jar "$JAVABASE" \
    -i "$MODEL_PATH/intermediate/service models/ms2.xmi" \
    -t "$TARGET_PATH" \
    --genlet "$SPRINGCLOUD" \
    --genlet "$SPRINGCLOUD_MTLS" \
    --genlet "$SPRINGCLOUD_KEYCLOAK"

