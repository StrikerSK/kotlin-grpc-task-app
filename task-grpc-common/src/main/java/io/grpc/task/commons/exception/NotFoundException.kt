package io.grpc.task.commons.exception

class NotFoundException: RuntimeException {

    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)

}