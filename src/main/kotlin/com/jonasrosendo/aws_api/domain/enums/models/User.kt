package com.jonasrosendo.aws_api.domain.enums.models

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val requests: List<Request> = arrayListOf(),
    val stages: List<RequestStage> = arrayListOf()
)