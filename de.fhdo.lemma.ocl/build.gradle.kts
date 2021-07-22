import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    id("com.diffplug.p2.asmaven") version "3.27.0"
    maven
}

group = "de.fhdo.lemma.ocl"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    val extractedEclipseDependenciesDir = project.file("$buildDir/extractedEclipseDependencies")
    extra.set("extractedEclipseDependenciesDir", extractedEclipseDependenciesDir)

    extra.set("eclipseOclVersion", "6.15.0")
}

/**
 * We use a plugin to specify and resolve OCL-specific Eclipse plugin dependencies that are not provided via Maven
 * Central. Instead, they are downloaded in the form of JAR files from their respective P2 repository hosted by the
 * Eclipse Foundation. Later in the build, the downloaded JARs can be used as "normal" dependencies as if they
 * originated from Maven Central.
 */
apply(plugin = "com.diffplug.p2.asmaven")
p2AsMaven {
    val eclipseOclVersion: String by rootProject.extra

    group("eclipse-deps") {
        repo("https://download.eclipse.org/modeling/mdt/ocl/updates/releases/$eclipseOclVersion/")
        iu("org.eclipse.ocl.ecore")

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
    implementation(kotlin("stdlib"))
    eclipseDependency("eclipse-deps:org.eclipse.emf.common:+")
    eclipseDependency("eclipse-deps:org.eclipse.emf.ecore:+")
    eclipseDependency("eclipse-deps:org.eclipse.emf.ecore.xmi:+")
    eclipseDependency("eclipse-deps:lpg.runtime.java:+")
    eclipseDependency("eclipse-deps:org.eclipse.ocl.ecore:+")
    eclipseDependency("eclipse-deps:org.eclipse.ocl:+")
    eclipseDependency("eclipse-deps:org.eclipse.ocl.common:+")

    // The custom eclipseDependency configuration does not allow for resolving the specified Eclipse dependencies
    // directly. Instead, we refer to the directory in the build folder, to which we extract the downloaded Eclipse
    // plugin JARs.
    val extractedEclipseDependenciesDir: File by rootProject.extra
    implementation(files(extractedEclipseDependenciesDir))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"

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

/**
 * allDependencies task to create a standalone fat JAR including all Eclipse-specific and other dependencies
 */
tasks.register("allDependencies", type = Jar::class) {
    archiveClassifier.set("all-dependencies")

    // Build fat JAR
    from(configurations.compileClasspath.get()
        .filter { it.exists() }
        .map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

/**
 * allDependencies task to create a standalone fat JAR including all Eclipse-specific and other dependencies, but
 * without the Kotlin standard library. That is, this dependency is to be used by Kotlin programs.
 */
val allDependenciesNoKotlin = task("allDependenciesNoKotlin", type = Jar::class) {
    val extractedEclipseDependenciesDir: File by rootProject.extra
    archiveClassifier.set("all-dependencies-no-kotlin")

    // Build fat JAR excluding Kotlin standard lib
    from(
        // We need explicitly to add the directory of downloaded Eclipse dependencies here as otherwise Gradle won't
        // include the contained dependency files in the "no Kotlin" fat JAR. Strangely, for the previous
        // allDependencies task we do not need to include the directory explicitly because Gradle implicitly adds its
        // contents to the produced "all dependencies" fat JAR.
        files(extractedEclipseDependenciesDir),
        configurations.compileClasspath.get()
            .filter{ it.exists() && !it.name.startsWith("kotlin") }
            .map { if (it.isDirectory) it else zipTree(it) }
    )
    with(tasks["jar"] as CopySpec)

    manifest {
        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

// Ensure that the allDependencies tasks are executed _after_ the Eclipse dependencies were downloaded and extracted to
// the sub-directory of the build folder
tasks["extractEclipseDependencies"].finalizedBy(tasks["allDependencies"])
tasks["allDependencies"].finalizedBy(tasks["allDependenciesNoKotlin"])

artifacts {
    add("archives", tasks["allDependencies"])
    add("archives", tasks["allDependenciesNoKotlin"])
}