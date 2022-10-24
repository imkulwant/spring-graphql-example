package com.kulsin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootGraphQLApplication

fun main(args: Array<String>) {

    SpringApplication.run(SpringBootGraphQLApplication::class.java, *args)

}