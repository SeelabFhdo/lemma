import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    id("com.diffplug.gradle.p2.asmaven") version "3.17.6"
    maven
}

group = "de.fhdo.lemma.ocl"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    val extractedEclipseDependenciesDir = project.file("$buildDir/extractedEclipseDependencies")
    extra.set("extractedEclipseDependenciesDir", extractedEclipseDependenciesDir)

    extra.set("eclipseVersion", "4.10.0")
    extra.set("eclipseOclVersion", "6.6.0")
}

/**
 * We use a plugin to specify and resolve OCL-specific Eclipse plugin dependencies that are not provided via Maven
 * Central. Instead, they are downloaded in the form of JAR files from their respective P2 repository hosted by the
 * Eclipse Foundation. Later in the build, the downloaded JARs can be used as "normal" dependencies as if they
 * originated from Maven Central.
 */
    apply(plugin = "com.diffplug.gradle.p2.asmaven")
p2AsMaven {
    val eclipseVersion: String by rootProject.extra
    val eclipseOclVersion: String by rootProject.extra

    group("eclipse-deps", {
        repo("https://download.eclipse.org/modeling/mdt/ocl/updates/releases/$eclipseOclVersion/")
        iu("org.eclipse.ocl.ecore")

        repoEclipse(eclipseVersion)
        iu("org.eclipse.emf.common")
        iu("org.eclipse.emf.ecore")
    })
}

/**
 * Define an custom configuration to collect all Eclipse-specific dependencies
 */
val eclipseDependency by configurations.creating

dependencies {
    implementation(kotlin("stdlib-jdk8"))
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
    kotlinOptions.jvmTarget = "1.8"

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
    archiveClassifier.set("all-dependencies-no-kotlin")

    // Build fat JAR excluding Kotlin standard lib
    from(configurations.compileClasspath.get().filter{ it.exists() && !it.name.startsWith("kotlin-stdlib") }
        .map { if (it.isDirectory) it else zipTree(it) })
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