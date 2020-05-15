import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.springcloud"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

buildscript {
    extra.set("classgraphVersion", "4.8.35")
    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.14.10")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("modelProcessingVersion", version)
    extra.set("xmlBuilderVersion", "1.5.2")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val javaBaseGeneratorVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val xmlBuilderVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:" +
        "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    implementation("org.redundent:kotlin-xml-builder:$xmlBuilderVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}