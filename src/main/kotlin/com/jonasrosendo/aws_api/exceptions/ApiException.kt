package com.jonasrosendo.aws_api.exceptions

import java.io.Serializable
import java.util.Date

open class ApiException(
    open val code: Int,
    open val internalCode: String,
    open val message: String,
    open val date: Date = Date()
) : Serializable
