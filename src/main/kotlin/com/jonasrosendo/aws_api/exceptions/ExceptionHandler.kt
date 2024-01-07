package com.jonasrosendo.aws_api.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException.NotFound

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFound::class)
    fun handleNotFoundException(
        exception: NotFound
    ): ResponseEntity<ApiException> {

        val error = ApiException(
            code = HttpStatus.NOT_FOUND.value(),
            internalCode = "",
            message = exception.message.toString()
        )

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }

}