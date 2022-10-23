package io.grpc.task.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("io.grpc.task.*")
open class TaskGrpcServer

fun main(args: Array<String>) {
    runApplication<TaskGrpcServer>(*args)
}