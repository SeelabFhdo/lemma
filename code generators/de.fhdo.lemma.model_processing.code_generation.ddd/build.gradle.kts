import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    id("com.diffplug.p2.asmaven") version "3.27.0"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.ddd"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    val extractedEclipseDependenciesDir = project.file("$buildDir/extractedEclipseDependencies")
    extra.set("extractedEclipseDependenciesDir", extractedEclipseDependenciesDir)

    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.14.10")
    extra.set("koinVersion", "2.0.1")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("modelProcessingVersion", version)
}

/**
 * We use a plugin to specify and resolve OCL-specific Eclipse plugin dependencies that are not provided via Maven
 * Central. Instead, they are downloaded in the form of JAR files from their respective P2 repository hosted by the
 * Eclipse Foundation. Later in the build, the downloaded JARs can be used as "normal" dependencies as if they
 * originated from Maven Central.
 */
apply(plugin = "com.diffplug.p2.asmaven")
p2AsMaven {
    group("eclipse-deps") {
        // Usually, you would use the following to add an official Eclipse release to the group using the
        // com.diffplug.p2.asmaven plugin:
        //      repoEclipse(eclipseVersion)
        // From the given eclipseVersion, the plugin will perform a mapping to an Eclipse relase URL
        // (cf. https://github.com/diffplug/goomph/blob/967ed7c3a96c33fda749f15f2b3d10065c32e359/src/main/java/com/diffplug/gradle/pde/EclipseRelease.java#L74).
        // However, all versions of com.diffplug.p2.asmaven greater 3.27.0 (tested up to 3.30.0) currently result in an
        // InvocationTargetException caused by an NPE (probably due to changes in Eclise release dependencies; cf.
        // https://github.com/diffplug/goomph/pull/145). Consequently, we are stuck to com.diffplug.p2.asmaven 3.27.0
        // for now. To still be able to depend on Eclipse 4.19 (2021-03), we therefore have to hardwire the Eclipse
        // release repository as follows:
        repo("https://download.eclipse.org/eclipse/updates/4.19/R-4.19-202103031800/")
        iu("org.eclipse.emf.common")
        iu("org.eclipse.emf.ecore")
    }
}

/**
 * Define an custom configuration to collect all Eclipse-specific dependencies
 */
val eclipseDependency by configurations.creating

dependencies {
    val javaBaseGeneratorVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
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

    eclipseDependency("eclipse-deps:org.eclipse.emf.common:+")
    eclipseDependency("eclipse-deps:org.eclipse.emf.ecore:+")

    // The custom eclipseDependency configuration does not allow for resolving the specified Eclipse dependencies
    // directly. Instead, we refer to the directory in the build folder, to which we extract the downloaded Eclipse
    // plugin JARs.
    val extractedEclipseDependenciesDir: File by rootProject.extra
    implementation(files(extractedEclipseDependenciesDir))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    // Java Base Generator uses @JvmDefault annotation
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")

    // On every compile, extract downloaded Eclipse JARs into a sub-directory of the build directory
    dependsOn("extractEclipseDependencies")
}

/**
 * Task to extract downloaded Eclipse JARs into a sub-directory of the build directory
 */
tasks.register("extractEclipseDependencies") {
    val extractedEclipseDependenciesDir: File by rootProject.extra

    inputs.files(eclipseDependency)
    outputs.dir(extractedEclipseDependenciesDir)
    extractedEclipseDependenciesDir.deleteRecursively()
    extractedEclipseDependenciesDir.mkdirs()

    // The extraction process has to be the last step of this task to make sure that the download process of the
    // Eclipse dependencies, which is triggered by the "p2AsMaven" plugin (see above), has been finished
    doLast {
        copy {
            from(eclipseDependency.map { if (it.isDirectory) it else zipTree(it) })
            into(extractedEclipseDependenciesDir)
        }
    }
}