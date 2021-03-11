import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    maven
}

group = "de.fhdo.lemma.visualizer"

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("classgraphVersion", "4.8.35")
    extra.set("jansiVersion", "1.17.1")
    extra.set("jgraphtVersion", "1.5.0")
    extra.set("lemmaEclipsePluginsVersion", version)
    extra.set("lsp4jVersion", "0.9.0")
    extra.set("modelProcessingVersion", version)
    extra.set("picocliVersion", "3.9.3")
    extra.set("xtextVersion", "2.21.0")
    extra.set("graphvizVersion", "0.18.1")
}

dependencies {
    val classgraphVersion: String by rootProject.extra
    val jansiVersion: String by rootProject.extra
    val jgraphtVersion: String by rootProject.extra
    val lemmaEclipsePluginsVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val modelProcessingVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra
    val xtextVersion: String by rootProject.extra
    val graphvizVersion: String by rootProject.extra

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:" +
            lemmaEclipsePluginsVersion)
    implementation("de.fhdo.lemma.live_validation:de.fhdo.lemma.live_validation:$lemmaEclipsePluginsVersion")
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$modelProcessingVersion")
    implementation("de.fhdo.lemma.model_processing.utils:de.fhdo.lemma.model_processing.utils:$modelProcessingVersion")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$lemmaEclipsePluginsVersion")
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("io.github.classgraph:classgraph:$classgraphVersion")
    implementation("org.jgrapht:jgrapht-core:$jgraphtVersion")
    implementation("org.jgrapht:jgrapht-ext:$jgraphtVersion")
    implementation("org.jgrapht:jgrapht-io:$jgraphtVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.eclipse.xtext:org.eclipse.xtext.ecore:$xtextVersion")
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    // https://mvnrepository.com/artifact/guru.nidi/graphviz-java
    implementation("guru.nidi:graphviz-java:$graphvizVersion")


}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "de.fhdo.lemma.visualizer.Visualizer")
    }
}

/**
 * standalone task to create a standalone runnable JAR of the Static Analyzer
 */
val standalone = task("standalone", type = Jar::class) {
    archiveClassifier.set("standalone")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        attributes("Main-Class" to "de.fhdo.lemma.visualizer.VisualizerKt")

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

// Mark standalone to be produced by build processes by default
artifacts {
    add("archives", standalone)
}