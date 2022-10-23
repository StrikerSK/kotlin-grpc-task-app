package io.grpc.task.server

import io.grpc.Status
import io.grpc.stub.StreamObserver
import io.grpc.task.commons.exception.NotFoundException
import io.grpc.task.proto.Task
import io.grpc.task.proto.TaskRequest
import io.grpc.task.proto.TaskServiceGrpc.TaskServiceImplBase
import io.grpc.task.server.service.ITaskService
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired

@GrpcService
class TaskGrpcService: TaskServiceImplBase() {

    @Autowired private lateinit var taskService: ITaskService

    override fun readTask(request: TaskRequest?, responseObserver: StreamObserver<Task>?) {
        try {
            val task = taskService.readTask(request!!.id)
            responseObserver!!.onNext(task)
            responseObserver.onCompleted()
        } catch (e: NotFoundException) {
            responseObserver!!.onError(Status.NOT_FOUND
                .withDescription(e.message)
                .asRuntimeException())
        } catch (e: Exception) {
            responseObserver!!.onError(Status.INTERNAL
                .withDescription("Error while reading task")
                .withCause(e)
                .asRuntimeException())
        }
    }

}