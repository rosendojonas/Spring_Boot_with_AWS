package com.jonasrosendo.aws_api.domain.dtos

import jakarta.persistence.Column

data class UserDTO(
    @Column(name = "name", length = 75, nullable = false)
    val name: String,
    @Column(name = "email", length = 75, nullable = false, unique = true)
    val email: String,
    @Column(name = "password", length = 100, nullable = false)
    val password: String
)