package io.grpc.task.server.service

import io.grpc.task.commons.entity.TaskDAO
import io.grpc.task.commons.exception.NotFoundException
import io.grpc.task.proto.Task
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

//@Service
class TaskInMemoryService: ITaskService {

    var tasks: List<TaskDAO> = ArrayList()

    override fun readTask(id: String): Task {
        val task = tasks.stream().filter { task -> task.getId() == id }.findFirst().orElseThrow { NotFoundException("Task not found") }
        return task.toTask()
    }

    override fun createTask(task: Task): String {
        val id = UUID.randomUUID().toString()
        val taskDAO = TaskDAO(task)
        taskDAO.setId(id)
        tasks = tasks.plus(taskDAO)
        return id
    }

//    override fun updateTask(id: String, task: TaskDAO) {
//        val taskToUpdate = getTask(id)
//        taskToUpdate.setName(task.getName())
//        taskToUpdate.setDescription(task.getDescription())
//    }
}