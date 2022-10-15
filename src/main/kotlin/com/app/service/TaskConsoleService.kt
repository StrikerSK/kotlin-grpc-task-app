package com.app.service

import com.app.entity.TaskDAO
import org.springframework.stereotype.Service

@Service
class TaskConsoleService: ITaskService  {

    override fun getTask(id: String): TaskDAO {
        println("Requested task: $id")
        return TaskDAO("Some fetched id", "Some fetched name", "Some fetched description")
    }

    override fun createTask(task: TaskDAO): String {
        println("Task id: ${task.getId()}")
        println("Task name: ${task.getName()}")
        return "123"
    }

    override fun updateTask(id: String, task: TaskDAO) {
        println("Task id: $id")
        println("Task name: ${task.getName()}")
    }

}