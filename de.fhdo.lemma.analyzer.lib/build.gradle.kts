import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    maven
}

group = "de.fhdo.lemma.analyzer"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("jgraphtVersion", "1.5.0")
    extra.set("lemmaEclipsePluginsVersion", version)
}

dependencies {
    val jgraphtVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))

    implementation("de.fhdo.lemma:de.fhdo.lemma.utils:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.technology.technologydsl:de.fhdo.lemma.technology.technologydsl.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("org.jgrapht:jgrapht-core:$jgraphtVersion")
    implementation("org.jgrapht:jgrapht-io:$jgraphtVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

/**
 * allDependencies task to create a standalone fat JAR of the Static Analysis Library
 */
val allDependencies = task("allDependencies", type = Jar::class) {
    archiveClassifier.set("all-dependencies")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
        attributes("Multi-Release" to "true")

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

/**
 * allDependenciesNoKotlin task to create a standalone fat JAR of the Static Analysis Library to be directly usable in
 * Kotlin projects
 */
val allDependenciesNoKotlin = task("allDependenciesNoKotlin", type = Jar::class) {
    archiveClassifier.set("all-dependencies-no-kotlin")

    // Build fat JAR excluding Kotlin standard lib
    from(configurations.compileClasspath.get().filter {
        it.exists() &&
                !it.name.startsWith("kotlin")
    }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
        attributes("Multi-Release" to "true")

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

// Mark allDependencies and allDependenciesNoKotlin as normal archives to be produced by build processes by default
artifacts {
    add("archives", allDependencies)
    add("archives", allDependenciesNoKotlin)
}