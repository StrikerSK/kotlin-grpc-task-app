package io.grpc.task.service

import com.github.javafaker.Faker
import io.grpc.task.proto.Task
import org.springframework.stereotype.Component

@Component
class TaskDummyService: ITaskService {

    private var faker = Faker()

    override fun readTask(id: String): Task {
        println("Requested task: $id")

        if (id.isEmpty()) {
            throw IllegalArgumentException("Task id is empty")
        }

        return Task.newBuilder()
            .setId(id)
            .setName(faker.job().title())
            .setDescription(faker.name().name())
            .build()
    }

    override fun createTask(task: Task): String {
        println("Task id: ${task.id}")
        println("Task name: ${task.name}")
        return "123"
    }

}