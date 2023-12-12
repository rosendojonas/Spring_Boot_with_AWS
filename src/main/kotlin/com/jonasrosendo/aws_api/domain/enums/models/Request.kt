package com.jonasrosendo.aws_api.domain.enums.models

import com.jonasrosendo.aws_api.domain.enums.RequestState
import java.util.Date

data class Request(
    val id: Long,
    val subject :String,
    val description: String,
    val creationDate: Date,
    val state: RequestState,
    val user: User,
    val stages: List<RequestStage> = arrayListOf()
)