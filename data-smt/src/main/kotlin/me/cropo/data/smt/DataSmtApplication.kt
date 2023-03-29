package me.cropo.data.smt

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class DataSmtApplication

fun main(args: Array<String>) {
    SpringApplication.run(DataSmtApplication::class.java, *args)
}