plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("groovyVersion", "3.0.3")
    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.14.10")
    extra.set("coroutinesVersion", "1.1.1")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("log4jVersion", "2.15.0")
    extra.set("loggingVersion", "1.7.9")
    extra.set("modelProcessingVersion", version)
}

dependencies {
    val groovyVersion: String by rootProject.extra
    val javaBaseGeneratorVersion: String by rootProject.extra
    val coroutinesVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val log4jVersion: String by rootProject.extra
    val loggingVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.util:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.model:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.protocol:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.client:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:" +
        "$modelProcessingVersion:all-dependencies-no-kotlin")
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:" +
        "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")
    // Required by log4j (Groovy execution engine)
    implementation("org.codehaus.groovy:groovy-jsr223:$groovyVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
        // Java Base Generator uses @JvmDefault annotation
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
        // Java Base Generator uses @JvmDefault annotation
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
}

/**
 * standalone task to create a standalone runnable JAR
 */
val standalone = task("standalone", type = Jar::class) {
    archiveClassifier.set("standalone")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        attributes("Main-Class" to "de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.CqrsGeneratorKt")

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

artifacts {
    add("archives", standalone)
}