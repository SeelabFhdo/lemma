plugins {
     java
    `maven-publish`
}

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("commonsIoVersion", "2.13.0")
    extra.set("commonsLangVersion", "3.13.0")
    extra.set("groovyVersion", "3.0.19")
    extra.set("log4jVersion", "2.20.0")
    extra.set("lsp4jVersion", "0.21.1")
    extra.set("picocliVersion", "4.7.5")
}

allprojects {
    apply(plugin = "java")

    group = "de.fhdo.lemma.live_validation"
    version = "$version"

    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:unchecked")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

subprojects {
    apply(plugin = "maven-publish")
}