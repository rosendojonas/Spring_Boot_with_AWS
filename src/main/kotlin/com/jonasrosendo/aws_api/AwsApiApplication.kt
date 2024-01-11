package com.jonasrosendo.aws_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class AwsApiApplication : SpringBootServletInitializer() {
	override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
		return builder.sources(AwsApiApplication::class.java)
	}
}

fun main(args: Array<String>) {
	runApplication<AwsApiApplication>(*args)
}
