package com.jonasrosendo.aws_api.web.mapper

import com.jonasrosendo.aws_api.domain.dtos.requests.CreateRequestDTO
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.Request
import com.jonasrosendo.aws_api.domain.models.User
import java.util.*

fun CreateRequestDTO.toRequest(
    state: RequestState,
    creationAt: Date,
    owner: User
): Request {
    return Request(
        subject = subject,
        description = description ?: "",
        creationAt = creationAt,
        state = state,
        owner = owner,
        stages = emptyList()
    )
}