#!/usr/bin/env bash

# Make sure to run Gradle with Java 11 or higher. Uncomment the following line and replace
# "/usr/lib/jvm/java-11-oracle/" with the path to your JDK >= 11 in case your default JDK is < 11.
#./gradlew -Dorg.gradle.java.home='/usr/lib/jvm/java-11-oracle/' clean jar
./gradlew clean jar