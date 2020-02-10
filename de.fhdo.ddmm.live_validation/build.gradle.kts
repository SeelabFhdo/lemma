import groovy.lang.GroovyObject
import org.apache.tools.ant.filters.ReplaceTokens
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.standardout.gradle.plugin.platform.PlatformPluginExtension
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    kotlin("jvm") version "1.3.30"
    maven

    /*
     * We use the "bnd-platform" plugin to create an Eclipse updatesite during the project's builds. The generated
     * updatesite can then be used by developers to install the components related to Live Validation to their Eclipse
     * development environments. This is necessary, for instance, to work on the LiveValidationCapableXtextEditor
     * located in the de.fhdo.ddmm.eclipse.ui.editor project.
     */
    id("org.standardout.bnd-platform") version "1.7.0"
}

group = "de.fhdo.ddmm"
// Initially set to 0.0.2, because 0.0.1 was somehow broken in the development machine's local Maven archive
version = "0.0.2-SNAPSHOT"
val MAIN_CLASS_NAME = "de.fhdo.ddmm.live_validation.server.ServerRunnerKt"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("groovyVersion", "2.5.6")
    extra.set("log4jVersion", "2.11.2")
    extra.set("loggingVersion", "1.6.24")
    extra.set("lsp4jVersion", "0.7.2")
    extra.set("picocliVersion", "3.9.3")
}

dependencies {
    val groovyVersion: String by rootProject.extra
    val log4jVersion: String by rootProject.extra
    val loggingVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("org.codehaus.groovy:groovy-jsr223:$groovyVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")
}

/**
 * Configuration for the "bnd-platform" plugin
 */
platform {
    val lsp4jVersion: String by rootProject.extra
    val versionQualifier = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))

    // Modifiy certain characteristics of the generated Live Validation Eclipse bundle
    val thisJarBnd = delegateClosureOf<GroovyObject> {
        withGroovyBuilder {
            "bnd" {
                "setVersion"("$version-$versionQualifier")
                "setSymbolicName"("$group.${rootProject.name}")
                "optionalImport"("kotlin.*", "mu", "org.apache.logging.*", "picocli")
            }
        }
    }
    bundle(file("build/libs/live_validation-$version.jar"), thisJarBnd)

    // Add further mandatory bundles
    bundle("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.21")
    bundle("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    bundle("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")

    // Specify features and updatesite properties
    featureId = "$group.${rootProject.name}"
    featureName = "Eclipse plugin of the DDMM Live Validation framework"
    featureVersion = version as String
    featureProvider = "DDMM Project"
    categoryName = "Modeling"
    hashQualifierMap = "bundle_version_history.json"
    defaultQualifierMap = mapOf("prefix" to "i", "baseDate" to PlatformPluginExtension.SECOND)
    hashCalculator = KotlinClosure1<String, ByteArray> ({
        // Return a new hash per build run, which leads to the build of a new, installable feature each time the build
        // is run, independent of whether the project's version changed
        versionQualifier.toByteArray()
    })
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "9"
}

/**
 * Extend the processResources task to include the application properties resource file and replace the version token
 * with the actual version of this build
 */
(tasks["processResources"] as ProcessResources).apply {
    from(file("src/main/resources/live_validation.properties")) {
        filter<ReplaceTokens>("tokens" to mapOf("application.version" to version))
    }
}

/**
 * runnableJar task to create a standalone runnable fat JAR
 */
val runnableJar = task("runnableJar", type = Jar::class) {
    archiveClassifier.set("runnable")

    manifest {
        attributes("Main-Class" to MAIN_CLASS_NAME)

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)
}

// Mark runnableJar as normal archive to be produced by build processes by default
artifacts {
    add("archives", runnableJar)
}

/**
 * buildUpdateSite task based on the "bnd-platform" plugin's updateSite task. It enhances the updateSite task with the
 * the production of a fresh JAR to be included in the resulting Eclipse updatesite.
 */
tasks["updateSite"].dependsOn(tasks["jar"])

task("buildUpdateSite") {
    group = "build"
    description = "Build Eclipse updatesite from scratch by also recompiling the Live Validation JAR"

    dependsOn(tasks["updateSite"])
}

/**
 * fullBuild task, which performs a Maven "clean install", including the generation of a runnable JAR and an updated
 * Eclipse updatesite
 */
task("fullBuild") {
    group = "build"
    description = "Builds JAR, runnable JAR, and Eclipse updatesite from scratch"

    dependsOn(tasks["clean"])
    dependsOn(tasks["jar"])
    dependsOn(tasks["runnableJar"])
    dependsOn(tasks["updateSite"])
    dependsOn(tasks["install"])
}