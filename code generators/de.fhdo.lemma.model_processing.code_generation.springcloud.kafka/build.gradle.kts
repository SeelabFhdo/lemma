import java.util.Properties

plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.springcloud.kafka"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("coroutinesVersion", "1.1.1")
    extra.set("groovyVersion", "3.0.3")
    extra.set("gsonVersion", "2.9.0")
    extra.set("jansiVersion", "1.17.1")
    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.24.2")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("log4jVersion", "2.16.0")
    extra.set("loggingVersion", "1.7.9")
    extra.set("lsp4jVersion", "0.10.0")
    extra.set("modelProcessingVersion", version)
    extra.set("picocliVersion", "3.9.3")
    extra.set("xmlBuilderVersion", "1.7.2")
}

dependencies {
    val resourcesPath = sourceSets.main.get().resources.srcDirs.first().absolutePath
    val propertiesPath = resourcesPath + File.separator + "kafka.genlet.properties"
    val properties = Properties()
    properties.load(File(propertiesPath).inputStream())
    val avroVersion = properties.getProperty("avro.version")

    val coroutinesVersion: String by rootProject.extra
    val groovyVersion: String by rootProject.extra
    val gsonVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val javaBaseGeneratorVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val log4jVersion: String by rootProject.extra
    val loggingVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val xmlBuilderVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("com.google.code.gson:gson:$gsonVersion")
    implementation("de.fhdo.lemma:de.fhdo.lemma.typechecking:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.util:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.model:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.protocol:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.client:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:" +
        "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.technology.mappingdsl:de.fhdo.lemma.technology.mappingdsl:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.technology.mappingdsl:" +
        "de.fhdo.lemma.technology.mappingdsl.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.technology.technologydsl:de.fhdo.lemma.technology.technologydsl:" +
        lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.technology.technologydsl:de.fhdo.lemma.technology.technologydsl.metamodel:" +
        lemmaEclipsePluginsVersion)
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")
    implementation("org.apache.avro:avro:$avroVersion")
    implementation("org.apache.avro:avro-compiler:$avroVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    // Required by log4j (Groovy execution engine)
    implementation("org.codehaus.groovy:groovy-jsr223:$groovyVersion")
    // Required by kotlin-xml-builder
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.redundent:kotlin-xml-builder:$xmlBuilderVersion")
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
    jar {
        from(configurations.compileClasspath.get()
            .filter{
                it.exists() && (
                    it.name.startsWith("avro") ||
                    it.name.startsWith("jackson") ||
                    it.name.startsWith("velocity")
                )
            }
            .map { if (it.isDirectory) it else zipTree(it) })
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
        attributes("Main-Class" to "de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.KafkaGeneratorKt")
        // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
        attributes("Multi-Release" to "true")

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

artifacts {
    add("archives", standalone)
}