plugins {
    java
    maven
}

repositories {
    mavenCentral()
    mavenLocal()
}

buildscript {
    extra.set("commonsIoVersion", "2.6")
    extra.set("commonsLangVersion", "3.12.0")
    extra.set("groovyVersion", "3.0.8")
    extra.set("log4jVersion", "2.16.0")
    extra.set("lsp4jVersion", "0.10.0")
    extra.set("picocliVersion", "4.6.1")
}

allprojects {
    apply(plugin = "java")

    group = "de.fhdo.lemma.live_validation"
    version = "$version"

    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:unchecked")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

subprojects {
    apply(plugin = "maven")
}