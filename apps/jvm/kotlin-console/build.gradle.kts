plugins {
    kotlin("jvm")
    application
}

group = "eu.sirotin.kotunil.app.kotlin"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("eu.sirotin.kotunil:kotunil-jvm:4.1.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("eu.sirotin.kotunil.app.kotlin.MainKt")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "eu.sirotin.kotunil.app.kotlin.MainKt"

    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}