package com.jonasrosendo.aws_api.domain.responses

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
)
