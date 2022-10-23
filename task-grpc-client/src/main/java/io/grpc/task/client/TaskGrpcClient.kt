package io.grpc.task.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("io.grpc.task.*")
open class TaskGrpcClient

fun main(args: Array<String>) {
    runApplication<TaskGrpcClient>(*args)
}