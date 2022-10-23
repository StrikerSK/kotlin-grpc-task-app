package io.grpc.task.server.service

import io.grpc.task.proto.Task
import org.springframework.stereotype.Service

@Service
class TaskDummyService: ITaskService {

    override fun readTask(id: String): Task {
        println("Requested task: $id")

        if (id.isEmpty()) {
            throw IllegalArgumentException("Task id is empty")
        }

        return generateTask(id)
    }

    override fun createTask(task: Task): String {
        println("Task id: ${task.id}")
        println("Task name: ${task.name}")
        println("Task description: ${task.description}")

        return "123"
    }

    private fun generateTask(id: String): Task {
        val taskNames: List<String> = listOf(
            "Clean house",
            "Go for walk",
            "Go to the gym",
            "Go to the cinema",
            "Go to the park",
            "Go to the beach"
        )

        val taskName = taskNames.random()

        return Task.newBuilder()
            .setId(id)
            .setName("$taskName - name")
            .setDescription("$taskName - description")
            .addAllTags(listOf("tag1", "tag2", "tag3"))
            .build()
    }

}