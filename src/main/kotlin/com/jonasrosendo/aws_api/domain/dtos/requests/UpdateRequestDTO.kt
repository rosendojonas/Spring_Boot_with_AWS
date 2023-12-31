package com.jonasrosendo.aws_api.domain.dtos.requests

import com.fasterxml.jackson.annotation.JsonProperty
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.utils.EMAIL_VALIDATION_PATTERN
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
data class UpdateRequestDTO(
    @Size(max = 75)
    val subject :String,
    val description: String? = null,
    @NotEmpty
    @Email(regexp = EMAIL_VALIDATION_PATTERN)
    @JsonProperty(value = "owner_email")
    val ownerEmail: String,
    val state: RequestState
)