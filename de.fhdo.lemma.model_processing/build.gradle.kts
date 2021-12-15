import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("classgraphVersion", "4.8.35")
    extra.set("coroutinesVersion", "1.1.1")
    extra.set("jansiVersion", "1.17.1")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("log4jVersion", "2.16.0")
    extra.set("loggingVersion", "1.7.9")
    extra.set("lsp4jVersion", "0.10.0")
    extra.set("oclVersion", version)
    extra.set("picocliVersion", "3.9.3")
    extra.set("xtextVersion", "2.25.0")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val coroutinesVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val log4jVersion: String by rootProject.extra
    val loggingVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val oclVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val xtextVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.util:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.model:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.protocol:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.client:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.ocl:de.fhdo.lemma.ocl:$oclVersion:all-dependencies-no-kotlin")
    implementation("de.fhdo.lemma:de.fhdo.lemma.utils:$lemmaEclipsePluginsVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")

    implementation("info.picocli:picocli:$picocliVersion")
    implementation("org.eclipse.xtext:org.eclipse.xtext.ecore:$xtextVersion")
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