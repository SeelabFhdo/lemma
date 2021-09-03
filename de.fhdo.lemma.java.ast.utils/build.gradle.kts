import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.java.ast.utils"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("javaParserVersion", "3.14.10")
    extra.set("lemmaEclipsePluginsVersion", version)
}

dependencies {
    val javaParserVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
            lemmaEclipsePluginsVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

/**
 * allDependencies task to create a standalone fat JAR of the Java Base Generator
 */
val allDependencies = task("allDependencies", type = Jar::class) {
    archiveClassifier.set("all-dependencies")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

/**
 * allDependenciesNoKotlin task to create a standalone fat JAR of the Java Base Generator to be directly usable in
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
        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

// Mark allDependencies and allDependenciesNoKotlin as normal archives to be produced by build processes by default
artifacts {
    add("archives", allDependencies)
    add("archives", allDependenciesNoKotlin)
}