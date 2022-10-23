package io.grpc.task.client.controller

import io.grpc.task.client.service.ITaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/task")
class TaskController {

    @Autowired private lateinit var taskService: ITaskService

    @GetMapping("/{id}")
    fun formTask(@PathVariable id: String, model: Model): String {
        model["task"] = taskService.readTask(id)
        return "detailPage"
    }

}