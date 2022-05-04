import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    maven
}

group = "de.fhdo.lemma.model_processing.code_generation.mtls.operations"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("classgraphVersion", "4.8.143")
    extra.set("commonsVersion", "3.12.0")
    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.24.2")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("modelProcessingVersion", version)
    extra.set("xmlBuilderVersion", "1.7.3")
    extra.set("picocliVersion", "3.9.3")
    extra.set("jansiVersion", "1.17.1")
    extra.set("log4jVersion", "2.17.2")
    extra.set("loggingVersion", "1.7.9")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val commonsVersion: String by rootProject.extra
    val javaBaseGeneratorVersion: String by rootProject.extra
    val javaParserVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val xmlBuilderVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val log4jVersion: String by rootProject.extra
    val loggingVersion: String by rootProject.extra


    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.github.javaparser:javaparser-core:$javaParserVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.operationdsl:de.fhdo.lemma.operationdsl:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.operation.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.operationdsl:de.fhdo.lemma.operationdsl.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation(
        "de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
                lemmaEclipsePluginsVersion
    )
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.util:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.model:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.protocol:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation.client:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")

    implementation(
        "de.fhdo.lemma.model_processing.code_generation.java_base:" +
                "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion"
    )
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")

//    implementation("de.fhdo.lemma.model_processing.code_generation.springcloud.mtls:" +
//            "de.fhdo.lemma.model_processing.code_generation.springcloud.mtls:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    // Required by kotlin-xml-builder
    implementation("org.apache.commons:commons-lang3:$commonsVersion")
    implementation("org.redundent:kotlin-xml-builder:$xmlBuilderVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    // Java Base Generator uses @JvmDefault annotation
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}

tasks.withType<Jar> {
    from(configurations.compileClasspath.get().filter { it.exists() }.map { if (it.isDirectory) it else zipTree(it) })

    manifest {
        attributes["Main-Class"] =
            "de.fhdo.lemma.model_processing.code_generation.mtls_operation.MTLSOperationsGeneratorKt"
        attributes["Multi-Release"] = "true"
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}