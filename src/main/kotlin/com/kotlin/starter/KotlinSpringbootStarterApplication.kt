package com.kotlin.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringbootStarterApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootStarterApplication>(*args)
}
