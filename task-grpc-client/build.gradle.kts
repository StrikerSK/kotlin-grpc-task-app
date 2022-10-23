plugins {
    id("java")
    id("idea")
    id("application")
    kotlin("jvm") version "1.7.20"
    id("org.springframework.boot") version "2.7.4"
}

dependencies {
    implementation(project(":task-grpc-common"))

    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("net.devh:grpc-client-spring-boot-starter:2.13.1.RELEASE")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    compileOnly("org.apache.tomcat:annotations-api:6.0.53")
}

configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
    imports {
        mavenBom("io.grpc:grpc-bom:1.49.1")
    }
}

tasks.getByName<Test>("test") {
    useTestNG()
}

application {
    mainClass.set("TaskGrpcClientKt")
}