#!/usr/bin/env bash

# Make sure to run Gradle with Java 17 or higher. Uncomment the following line and replace
# "/usr/lib/jvm/java-11-oracle/" with the path to your JDK >= 17 in case your default JDK is < 17.
#./gradlew -Dorg.gradle.java.home='/usr/lib/jvm/java-11-oracle/' clean jar
./gradlew clean jar