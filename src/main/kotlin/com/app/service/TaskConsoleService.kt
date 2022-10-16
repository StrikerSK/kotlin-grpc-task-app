package com.app.service

import com.app.entity.TaskDAO
import com.github.javafaker.Faker

//@Service
class TaskConsoleService: ITaskService  {

    private var faker = Faker()

    override fun getTask(id: String): TaskDAO {
        println("Requested task: $id")
        return TaskDAO(id, faker.job().title(), faker.name().name())
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