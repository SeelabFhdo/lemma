import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.utils"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("modelProcessingVersion", version)
}

dependencies {
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation("de.fhdo.lemma:de.fhdo.lemma.utils:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.technology.mappingdsl:de.fhdo.lemma.technology.mappingdsl.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.technology.technologydsl:de.fhdo.lemma.technology.technologydsl.metamodel:" +
        lemmaEclipsePluginsVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

/**
 * allDependencies task to create a standalone fat JAR to be directly usable by model processing implementers
 */
val allDependencies = task("allDependencies", type = Jar::class) {
    archiveClassifier.set("all-dependencies")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
        "Multi-Release" to "true"

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

/**
 * allDependenciesNoKotlin task to create a standalone fat JAR to be directly usable by model processing implementers
 * written in Kotlin
 */
val allDependenciesNoKotlin = task("allDependenciesNoKotlin", type = Jar::class) {
    archiveClassifier.set("all-dependencies-no-kotlin")

    // Build fat JAR excluding Kotlin standard lib
    from(configurations.compileClasspath.get().filter {
        it.exists() && !it.name.startsWith("kotlin")
    }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
        "Multi-Release" to "true"

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

// Mark allDependencies and allDependenciesNoKotlin as normal archives to be produced by build processes by default
artifacts {
    add("archives", allDependencies)
    add("archives", allDependenciesNoKotlin)
}