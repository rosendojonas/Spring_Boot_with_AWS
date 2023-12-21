package com.jonasrosendo.aws_api.web.mapper

import com.jonasrosendo.aws_api.domain.UserResponse
import com.jonasrosendo.aws_api.domain.dtos.UserDTO
import com.jonasrosendo.aws_api.domain.models.User


fun User.toDto(): UserDTO {
    return UserDTO(
        name = name,
        email = email,
        password = password
    )
}

fun UserDTO.toUser(): User {
    return User(
        name = name,
        email = email,
        password = password
    )
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id ?: throw RuntimeException("user id is null"),
        name = name,
        email = email
    )
}