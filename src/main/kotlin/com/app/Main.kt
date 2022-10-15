package com.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.app.*")
class ApplicationMain

fun main(args: Array<String>) {
    runApplication<ApplicationMain>(*args)
}