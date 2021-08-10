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
    extra.set("javaBaseGeneratorVersion", version)
    extra.set("javaParserVersion", "3.14.10")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("modelProcessingVersion", version)
}

dependencies {
    val javaBaseGeneratorVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:" +
            lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:" +
            lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation:" +
            lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:" +
            "$modelProcessingVersion:all-dependencies-no-kotlin")
    implementation("de.fhdo.lemma.model_processing.code_generation.java_base:" +
            "de.fhdo.lemma.model_processing.code_generation.java_base:$javaBaseGeneratorVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:" +
            modelProcessingVersion)
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")
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