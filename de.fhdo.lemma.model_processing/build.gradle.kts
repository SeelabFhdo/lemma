import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    maven
}

group = "de.fhdo.lemma.model_processing"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("classgraphVersion", "4.6.32")
    extra.set("coroutinesVersion", "1.1.1")
    extra.set("lemmaUtilsVersion", "0.0.1-SNAPSHOT")
    extra.set("equinoxVersion", "3.10.0")
    extra.set("jansiVersion", "1.17.1")
    extra.set("jdtCoreVersion", "3.13.102")
    extra.set("liveValidationVersion", "0.0.2-SNAPSHOT")
    extra.set("lsp4jVersion", "0.6.0")
    extra.set("oclVersion", "0.0.1-SNAPSHOT")
    extra.set("picocliVersion", "3.9.3")
    extra.set("xtextVersion", "2.16.0")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val coroutinesVersion: String by rootProject.extra
    val lemmaUtilsVersion: String by rootProject.extra
    val equinoxVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val jdtCoreVersion:String by rootProject.extra
    val liveValidationVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val oclVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val xtextVersion: String by rootProject.extra

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation:$liveValidationVersion")
    implementation("de.fhdo.lemma.ocl:de.fhdo.lemma.ocl:$oclVersion:all-dependencies-no-kotlin")
    implementation("de.fhdo.lemma:de.fhdo.lemma.utils:$lemmaUtilsVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")

    implementation("info.picocli:picocli:$picocliVersion")
    implementation("org.eclipse.xtext:org.eclipse.xtext.ecore:$xtextVersion")

    // Workaround for https://github.com/eclipse/xtext/issues/1231. Remove with upgrade to Xtext 2.15.
    implementation("org.eclipse.jdt:org.eclipse.jdt.core:$jdtCoreVersion")
    implementation("org.eclipse.platform:org.eclipse.equinox.common:$equinoxVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "9"
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