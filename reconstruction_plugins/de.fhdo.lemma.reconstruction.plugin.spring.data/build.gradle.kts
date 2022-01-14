import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
}

group = "de.fhdo.lemma.reconstruction.plugin.spring.data"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("classgraphVersion", "4.8.35")
    extra.set("commonsVersion", "3.5")
    extra.set("jansiVersion", "1.17.1")
    extra.set("koinVersion", "2.0.1")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("lsp4jVersion", "0.9.0")
    extra.set("picocliVersion", "3.9.3")
    extra.set("xmlBuilderVersion", "1.7.2")
    extra.set("softwareReconstructionVersion", version)
    extra.set("javaParserVersion", "3.14.10")
    extra.set("modelProcessingVersion", version)
    extra.set("lemmaEclipsePluginsVersion", version)
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val commonsVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val xmlBuilderVersion: String by rootProject.extra
    val softwareReconstructionVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("de.fhdo.lemma.reconstruction.framework:" +
            "de.fhdo.lemma.reconstruction.framework:$softwareReconstructionVersion:all-dependencies-no-kotlin")
    implementation("de.fhdo.lemma.reconstruction.java.util:" +
            "de.fhdo.lemma.reconstruction.java.util:$softwareReconstructionVersion:all-dependencies-no-kotlin")

    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    implementation("io.insert-koin:koin-core:$koinVersion")
    // Required by kotlin-xml-builder
    implementation("org.apache.commons:commons-lang3:$commonsVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.redundent:kotlin-xml-builder:$xmlBuilderVersion")

    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:de.fhdo.lemma.model_processing.code_generation.java_base:$lemmaEclipsePluginsVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    // Support @JvmDefault annotation
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}

tasks.withType<AbstractArchiveTask> {
    setProperty("duplicatesStrategy", DuplicatesStrategy.EXCLUDE)
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

/**
 * standalone task to create a standalone runnable JAR of the Java Base Generator
 */
val standalone = task("standalone", type = Jar::class) {
    archiveClassifier.set("standalone")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        attributes("Main-Class" to "de.fhdo.software.architecture.reconstruction.framework.SoftwareArchitectureReconstructionKt")

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

// Mark allDependencies and allDependenciesNoKotlin as normal archives to be produced by build processes by default
artifacts {
    add("archives", allDependencies)
    add("archives", allDependenciesNoKotlin)
    add("archives", standalone)
}