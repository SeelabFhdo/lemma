import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.java_base"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

buildscript {
    extra.set("classgraphVersion", "4.6.32")
    extra.set("dataDslVersion", "0.0.1-SNAPSHOT")
    extra.set("intermediateDataModelVersion", "0.0.1-SNAPSHOT")
    extra.set("intermediateServiceModelVersion", "0.0.1-SNAPSHOT")
    extra.set("jansiVersion", "1.17.1")
    extra.set("javaParserVersion", "3.14.10")
    extra.set("koinVersion", "2.0.1")
    extra.set("liveValidationVersion", "0.0.2-SNAPSHOT")
    extra.set("lsp4jVersion", "0.9.0")
    extra.set("modelProcessingVersion", "0.0.1-SNAPSHOT")
    extra.set("modelProcessingUtilsVersion", "0.0.1-SNAPSHOT")
    extra.set("picocliVersion", "3.9.3")
    extra.set("serviceDslVersion", "0.0.1-SNAPSHOT")
    extra.set("xmlBuilderVersion", "1.5.2")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val dataDslVersion: String by rootProject.extra
    val intermediateDataModelVersion: String by rootProject.extra
    val intermediateServiceModelVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val liveValidationVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val modelProcessingUtilsVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val serviceDslVersion: String by rootProject.extra
    val xmlBuilderVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:$dataDslVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$dataDslVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:" +
        intermediateDataModelVersion)
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
        intermediateServiceModelVersion)
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation:$liveValidationVersion")

    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:" +
        modelProcessingUtilsVersion)
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$serviceDslVersion")
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.koin:koin-core:$koinVersion")
    implementation("org.redundent:kotlin-xml-builder:$xmlBuilderVersion")
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

/**
 * standalone task to create a standalone runnable JAR of the Java Base Generator
 */
val standalone = task("standalone", type = Jar::class) {
    archiveClassifier.set("standalone")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        attributes("Main-Class" to "de.fhdo.lemma.model_processing.code_generation.java_base.JavaBaseGeneratorKt")

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