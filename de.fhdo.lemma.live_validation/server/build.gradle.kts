plugins {
    java
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    val commonsIoVersion: String by rootProject.extra
    val commonsLangVersion: String by rootProject.extra
    val groovyVersion: String by rootProject.extra
    val log4jVersion: String by rootProject.extra
    val lsp4jVersion: String by rootProject.extra
    val picocliVersion: String by rootProject.extra

    implementation("commons-io:commons-io:$commonsIoVersion")
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("org.apache.commons:commons-lang3:$commonsLangVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.codehaus.groovy:groovy-jsr223:$groovyVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")

    implementation(project(":${rootProject.name}.util"))
    implementation(project(":${rootProject.name}.model"))
    implementation(project(":${rootProject.name}.protocol"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

/**
 * Extend the processResources task to include the application properties resource file and replace the version token
 * with the actual version of this build
 */
(tasks["processResources"] as ProcessResources).apply {
    from(file("src/main/resources/live_validation.properties")) {
        filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to mapOf("application.version" to version))
    }
}

/**
 * runnableJar task to create a standalone runnable fat JAR
 */
val runnableJar = task("runnableJar", type = Jar::class) {
    archiveClassifier.set("runnable")

    manifest {
        attributes(
            "Main-Class" to "de.fhdo.lemma.live_validation.server.ServerRunner",
            // Prevent "WARNING: sun.reflect.Reflection.getCallerClass is not supported" from log4j
            "Multi-Release" to "true"
        )

        // Prevent security exception from JAR verifier
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
    }

    // Build fat JAR
    from(configurations.compileClasspath.get().filter{ it.exists() }.map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)
}

// Mark runnableJar as normal archive to be produced by build processes by default
artifacts {
    add("archives", runnableJar)
}