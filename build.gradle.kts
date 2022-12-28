import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "ss.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging:2.1.21")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("ch.qos.logback:logback-core:1.2.10")
    implementation("ch.qos.logback:logback-classic:1.2.10")

    implementation("org.apache.kafka:kafka-clients:3.3.1")


    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}