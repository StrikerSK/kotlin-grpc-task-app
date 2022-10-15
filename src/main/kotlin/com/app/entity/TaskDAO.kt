package com.app.entity

class TaskDAO {

    private var id: String
    private var name: String
    private var description: String

    constructor() {
        this.id = ""
        this.name = ""
        this.description = ""
    }

    constructor(id: String, name: String, description: String) {
        this.id = id
        this.name = name
        this.description = description
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

}