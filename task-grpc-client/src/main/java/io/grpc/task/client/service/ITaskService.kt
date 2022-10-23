package io.grpc.task.client.service

import io.grpc.task.commons.entity.TaskDAO

interface ITaskService {

    fun readTask(id: String): TaskDAO

}