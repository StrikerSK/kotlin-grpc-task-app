package com.app.service

import com.app.entity.TaskDAO
import com.app.exception.NotFoundException
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class TaskInMemoryService: ITaskService {

    var tasks: List<TaskDAO> = ArrayList()

    override fun getTask(id: String): TaskDAO {
        return tasks.stream().filter { task -> task.getId() == id }.findFirst().orElseThrow { NotFoundException("Task not found") }
    }

    override fun createTask(task: TaskDAO): String {
        val id = UUID.randomUUID().toString()
        task.setId(id)
        tasks = tasks.plus(task)
        return id
    }

    override fun updateTask(id: String, task: TaskDAO) {
        val taskToUpdate = getTask(id)
        taskToUpdate.setName(task.getName())
        taskToUpdate.setDescription(task.getDescription())
    }
}