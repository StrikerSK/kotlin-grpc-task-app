import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.7.20"
    kotlin("jvm") version "1.7.20"
    application
}

allprojects {
    group = "io.grpc.task"
    version = "1.0.0"

    dependencies {
        repositories {
            mavenCentral()
        }
    }
}

subprojects {
    apply {
        plugin("io.spring.dependency-management")
    }
}

tasks.test {
    useTestNG()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}