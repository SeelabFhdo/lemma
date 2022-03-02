plugins {
    java
}

group = "de.fhdo.lemma.examples.model_processing.latest"

repositories {
    mavenCentral()

    // Local Maven repository for versions of required LEMMA dependencies that might not have been deployed, yet
    mavenLocal()

    maven {
        // Repository of LEMMA artifacts
        url = uri("https://repository.seelab.fh-dortmund.de/repository/maven-public/")
    }
}

dependencies {
    // Dependency for LEMMA's model processing framework. Note the "all-dependencies" classifier, which points to a
    // convenience fat JAR of the framework that comprises all necessary dependencies.
    implementation("de.fhdo.lemma.model_processing:de.fhdo.lemma.model_processing:$version:all-dependencies")

    // Dependencies to LEMMA's Service Modeling Language and its metamodel. These dependencies are needed by the example
    // model processor to support parsing of service models in their "source form", i.e., as they were constructed with
    // the Eclipse IDE within files having the ".services" extension.
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl:$version")
    implementation("de.fhdo.lemma.servicedsl:de.fhdo.lemma.servicedsl.metamodel:$version")

    // Dependencies to LEMMA's Domain Data Modeling Language and its metamodel. These dependencies are also needed by
    // the example model processor to support parsing of service models. That is, because the Service Modeling Language
    // draws on the type system provided by the Domain Data Modeling Language.
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl:$version")
    implementation("de.fhdo.lemma.data.datadsl:de.fhdo.lemma.data.datadsl.metamodel:$version")

    // Dependencies for the intermediate specification for LEMMA service models. These dependencies are needed by the
    // example model processor to support parsing of intermediate service models. Note that we also require the
    // intermediate specification for LEMMA domain models, because the intermediate specification for LEMMA service
    // models draws on the type system provided by the intermediate specification for LEMMA domain models.
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.data.intermediate.metamodel:$version")
    implementation("de.fhdo.lemma.intermediate:de.fhdo.lemma.service.intermediate.metamodel:$version")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<AbstractArchiveTask> {
    archiveVersion.set("")
    setProperty("duplicatesStrategy", DuplicatesStrategy.EXCLUDE)
}

/**
 * standalone task to create a standalone runnable JAR of the example model processor
 */
val standalone = task("standalone", type = Jar::class) {
    archiveClassifier.set("standalone")

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)

    manifest {
        attributes("Main-Class" to "de.fhdo.lemma.examples.model_processing.latest.ExampleModelProcessor")
        // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
        "Multi-Release" to "true"

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }
}

tasks.getByName<Jar>("jar") {
    finalizedBy(standalone)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}