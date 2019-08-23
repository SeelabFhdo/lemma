import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.java_base"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

buildscript {
    extra.set("classgraphVersion", "4.6.32")
    extra.set("dataDslVersion", "0.0.1-SNAPSHOT")
    extra.set("intermediateDataModelVersion", "0.0.1-SNAPSHOT")
    extra.set("intermediateServiceModelVersion", "0.0.1-SNAPSHOT")
    extra.set("javaParserVersion", "3.14.10")
    extra.set("koinVersion", "2.0.1")
    extra.set("modelProcessingVersion", "0.0.1-SNAPSHOT")
    extra.set("modelProcessingUtilsVersion", "0.0.1-SNAPSHOT")
    extra.set("picocliVersion", "3.9.3")
    extra.set("serviceDslVersion", "0.0.1-SNAPSHOT")
    extra.set("xmlBuilderVersion", "1.5.2")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val dataDslVersion: String by rootProject.extra
    val intermediateDataModelVersion: String by rootProject.extra
    val intermediateServiceModelVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val modelProcessingUtilsVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val serviceDslVersion: String by rootProject.extra
    val xmlBuilderVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$dataDslVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:" +
            "$intermediateDataModelVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
        "$intermediateServiceModelVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:" +
        "$modelProcessingUtilsVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$serviceDslVersion")
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    implementation("org.koin:koin-core:$koinVersion")
    implementation("org.redundent:kotlin-xml-builder:$xmlBuilderVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}