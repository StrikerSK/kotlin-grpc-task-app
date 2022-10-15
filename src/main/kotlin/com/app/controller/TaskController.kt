package com.app.controller

import com.app.entity.TaskDAO
import com.app.service.ITaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/task")
class TaskController {

    @Autowired private lateinit var taskService: ITaskService

    @GetMapping
    fun formTask(model: Model): String {
        return "taskForm"
    }

    @PostMapping("/add")
    fun createTask(@ModelAttribute task: TaskDAO, model: Model): String {
        taskService.createTask(task)
        model["task"] = task
        return "taskOverview"
    }

}