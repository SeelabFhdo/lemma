import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.ddd"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

buildscript {
    extra.set("intermediateDataModelVersion", "0.0.1-SNAPSHOT")
    extra.set("javaBaseGeneratorVersion", "0.0.1-SNAPSHOT")
    extra.set("javaParserVersion", "3.14.10")
    extra.set("koinVersion", "2.0.1")
    extra.set("modelProcessingVersion", "0.0.1-SNAPSHOT")
    extra.set("modelProcessingUtilsVersion", "0.0.1-SNAPSHOT")
}

dependencies {
    val intermediateDataModelVersion: String by rootProject.extra
    val javaBaseGeneratorVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val modelProcessingUtilsVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:" +
        intermediateDataModelVersion)
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:" +
        "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:" +
        modelProcessingUtilsVersion)
    implementation("org.koin:koin-core:$koinVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}