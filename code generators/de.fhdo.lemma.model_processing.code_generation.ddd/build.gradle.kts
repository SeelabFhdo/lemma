import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.ddd"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.14.10")
    extra.set("koinVersion", "2.0.1")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("modelProcessingVersion", version)
}

dependencies {
    val javaBaseGeneratorVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.java.ast.utils:de.fhdo.lemma.java.ast.utils:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.util:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.model:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.protocol:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.client:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:" +
        "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("io.insert-koin:koin-core:$koinVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    // Java Base Generator uses @JvmDefault annotation
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}