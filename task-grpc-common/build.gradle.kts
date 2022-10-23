import com.google.protobuf.gradle.id

plugins {
    id("application")
    id("java")
    kotlin("jvm") version "1.7.20"
    id("com.google.protobuf") version "0.9.1"
}

repositories {
    maven {
        setUrl("https://maven-central.storage-download.googleapis.com/maven2/")
    }

    mavenCentral()
    mavenLocal()
}

var grpcVersion = "1.49.1" // CURRENT_GRPC_VERSION
var protobufVersion = "3.21.6"
var protocVersion = protobufVersion

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:${properties["kotlin.version"]}")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    implementation("com.google.protobuf:protobuf-java-util:${protobufVersion}")
    runtimeOnly("io.grpc:grpc-netty:${grpcVersion}")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")

    testImplementation("io.grpc:grpc-testing:${grpcVersion}")
}

dependencyManagement {
    imports {
        mavenBom("com.google.protobuf:protobuf-bom:${protobufVersion}")
        mavenBom("io.grpc:grpc-bom:${grpcVersion}")
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protocVersion}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                id("grpc") {}
            }
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs(
                "build/generated/source/proto/main/kotlin",
                "build/generated/source/proto/main/grpc"
            )
        }
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}