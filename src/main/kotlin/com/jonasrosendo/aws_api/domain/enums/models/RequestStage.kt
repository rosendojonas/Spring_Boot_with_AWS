package com.jonasrosendo.aws_api.domain.enums.models

import com.jonasrosendo.aws_api.domain.enums.RequestState
import java.util.Date

data class RequestStage(
    val id: Long,
    val description: String,
    val realizationDate: Date,
    val state: RequestState,
    val request: Request,
    val user: User
)