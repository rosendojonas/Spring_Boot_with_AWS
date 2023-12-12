package com.jonasrosendo.aws_api.domain.enums.models

import com.jonasrosendo.aws_api.domain.enums.Role

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val role: Role,
    val requests: List<Request> = arrayListOf(),
    val stages: List<RequestStage> = arrayListOf()
)