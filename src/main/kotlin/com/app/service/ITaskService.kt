package com.app.service

import com.app.entity.TaskDAO

interface ITaskService {

    fun getTask(id: String): TaskDAO
    fun createTask(task: TaskDAO): String
    fun updateTask(id: String, task: TaskDAO)

}