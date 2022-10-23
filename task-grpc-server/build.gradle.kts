import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    id("java")
    id("idea")
    id("application")
    kotlin("jvm") version "1.7.20"
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "io.grpc.task.server"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":task-grpc-common"))

    implementation("org.yaml:snakeyaml:1.33")
    implementation("org.springframework.boot:spring-boot-starter:2.7.4") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("net.devh:grpc-server-spring-boot-starter:2.13.1.RELEASE")
    implementation("com.github.javafaker:javafaker:1.0.2") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    compileOnly("org.apache.tomcat:annotations-api:6.0.53")
}

configure<DependencyManagementExtension> {
    imports {
        mavenBom("io.grpc:grpc-bom:1.49.1")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClass.set("TaskGrpcServerKt")
}