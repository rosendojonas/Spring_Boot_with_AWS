package com.jonasrosendo.aws_api.domain.dtos.users

import com.jonasrosendo.aws_api.utils.EMAIL_VALIDATION_PATTERN
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class UserDTO(
    @NotEmpty
    @Size(max = 75)
    val name: String,

    @NotEmpty
    @Size(max = 75)
    @Email(regexp = EMAIL_VALIDATION_PATTERN)
    val email: String,

    @NotBlank
    @Size(min = 8)
    val password: String
)