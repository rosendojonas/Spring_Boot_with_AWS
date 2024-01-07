package com.jonasrosendo.aws_api.exceptions

import java.util.*

data class ApiExceptionsList(
    override val code: Int,
    override val internalCode: String,
    override val message: String,
    override val date: Date = Date(),
    val errors: List<String> = listOf()
) : ApiException(code, internalCode, message, date)