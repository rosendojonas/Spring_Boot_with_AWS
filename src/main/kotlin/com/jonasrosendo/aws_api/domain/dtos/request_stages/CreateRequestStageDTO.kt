package com.jonasrosendo.aws_api.domain.dtos.request_stages

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Size

data class CreateRequestStageDTO(
    @Size(min = 10)
    val description: String,
    @JsonProperty(value = "request_id")
    val requestId: Long,
    @JsonProperty(value = "owner_id")
    val ownerId: Long
)
