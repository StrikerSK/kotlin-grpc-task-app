package io.grpc.task.service

import io.grpc.task.proto.Task

interface ITaskService {

    fun readTask(id: String): Task
    fun createTask(task: Task): String

}