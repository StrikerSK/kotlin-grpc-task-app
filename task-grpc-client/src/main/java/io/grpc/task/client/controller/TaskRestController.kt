package io.grpc.task.client.controller

import io.grpc.task.client.service.ITaskService
import io.grpc.task.commons.entity.TaskDAO
import io.grpc.task.commons.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/task")
class TaskRestController {

    @Autowired private lateinit var taskService: ITaskService

    @GetMapping("/{id}")
    fun readTask(@PathVariable("id") id: String): ResponseEntity<TaskDAO> {
        return try {
            val task = taskService.readTask(id)
            ResponseEntity.ok(task)
        } catch (e: NotFoundException) {
            ResponseEntity.notFound().build()
        } catch (e: Exception) {
            ResponseEntity.internalServerError().build()
        }
    }

}