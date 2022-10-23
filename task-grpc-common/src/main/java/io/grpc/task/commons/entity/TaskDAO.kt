package io.grpc.task.commons.entity

import io.grpc.task.proto.Task

class TaskDAO {

    private var id: String
    private var name: String
    private var description: String
    private var tags: List<String>

    constructor() {
        this.id = ""
        this.name = ""
        this.description = ""
        this.tags = ArrayList()
    }

    constructor(task: Task) {
        this.id = task.id
        this.name = task.name
        this.description = task.description
        this.tags = task.tagsList
    }

    fun getId(): String {
        return this.id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return this.name
    }

    fun getDescription(): String {
        return this.description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getTags(): List<String> {
        return this.tags
    }

    fun setTags(tags: List<String>) {
        this.tags = tags
    }

    fun toTask(): Task {
        return Task.newBuilder()
                .setId(this.id)
                .setName(this.name)
                .setDescription(this.description)
                .addAllTags(this.tags)
                .build()
    }

}