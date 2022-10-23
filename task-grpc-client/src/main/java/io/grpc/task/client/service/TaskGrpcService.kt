package io.grpc.task.client.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.task.commons.entity.TaskDAO
import io.grpc.task.commons.exception.NotFoundException
import io.grpc.task.proto.TaskRequest
import io.grpc.task.proto.TaskServiceGrpc
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service

@Service
class TaskGrpcService: ITaskService {

    @GrpcClient("tasks") lateinit var stub: TaskServiceGrpc.TaskServiceBlockingStub

    override fun readTask(id: String): TaskDAO {
        try {
            val taskRequest = TaskRequest.newBuilder().setId(id).build()
            val task = stub.readTask(taskRequest)
            return TaskDAO(task)
        } catch (e: StatusRuntimeException) {
            if (e.status == Status.NOT_FOUND) {
                throw NotFoundException("Task [$id] not found")
            } else {
                println("RPC failed: ${e.status}")
                throw RuntimeException("Something went wrong")
            }
        } catch (e: Exception) {
            print("Something went wrong: ${e.message}")
            throw RuntimeException("Something went wrong")
        }
    }

}