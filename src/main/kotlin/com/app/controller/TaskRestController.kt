package com.app.controller

import com.app.entity.TaskDAO
import com.app.service.ITaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/task")
class TaskRestController {

    @Autowired private lateinit var taskService: ITaskService

    @GetMapping("/{id}")
    fun getTasks(@PathVariable("id") id: String): ResponseEntity<TaskDAO> {
        return ResponseEntity.ok().body(taskService.getTask(id))
    }

    @PostMapping
    fun createTask(@RequestBody task: TaskDAO): ResponseEntity<String> {
        val id = taskService.createTask(task)
        return ResponseEntity.ok().body(id)
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: String, @RequestBody task: TaskDAO): ResponseEntity<String> {
        val id = taskService.createTask(task)
        return ResponseEntity.ok().body(id)
    }

}