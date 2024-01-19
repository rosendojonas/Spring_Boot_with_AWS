package com.jonasrosendo.aws_api.domain.dtos.auth

import com.jonasrosendo.aws_api.utils.EMAIL_VALIDATION_PATTERN
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserAuthenticationDTO(

    @NotBlank
    @Email(
        message = "Invalid e-mail format",
        regexp = EMAIL_VALIDATION_PATTERN
    )
    val email: String,
    @Size(min = 8)
    val password: String
)