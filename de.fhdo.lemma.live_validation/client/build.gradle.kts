plugins {
    java
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    val lsp4jVersion: String by rootProject.extra

    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")

    implementation(project(":${rootProject.name}.util"))
    implementation(project(":${rootProject.name}.model"))
    implementation(project(":${rootProject.name}.protocol"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}