#!/usr/bin/env bash

# Run the "build.sh" script before this script to ensure that the standalone JAR file of the example model processor
# exists.

# Make sure to run the following line with Java 11 or higher
java -jar build/libs/de.fhdo.lemma.examples.model_processing-standalone.jar \
  --source_model "example models/microservices/Order.services" \
  --intermediate_model "example models/intermediate/service models/Order.xmi" \
  --target_folder "generated code"