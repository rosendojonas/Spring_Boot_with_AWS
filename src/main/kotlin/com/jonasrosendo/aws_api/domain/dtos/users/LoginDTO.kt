package com.jonasrosendo.aws_api.domain.dtos.users

import com.jonasrosendo.aws_api.utils.EMAIL_VALIDATION_PATTERN
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class LoginDTO(

    @NotEmpty(message = "E-mail should not be empty")
    @Email(
        message = "E-mail not valid",
        regexp = EMAIL_VALIDATION_PATTERN
    )
    val email: String,

    @NotEmpty(message = "Password should not be empty")
    @Size(message =  "Password should be between 8 and 64 chars", min = 8, max = 64)
    val password: String
)
