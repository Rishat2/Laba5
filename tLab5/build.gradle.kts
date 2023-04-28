import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("org.jetbrains.dokka") version "1.7.10"
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("MainKt")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0-RC")
    //implementation("com.ryanharter.kotlinx.serialization:kotlinx-serialization-xml:0.0.1-SNAPSHOT")
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.2.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.jar {
    manifest.attributes["Main-Class"] = "MainKt"
    from(
        configurations
            .runtimeClasspath
            .get()
            .map { zipTree(it) }
    )
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

