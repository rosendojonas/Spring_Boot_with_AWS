package com.jonasrosendo.aws_api.web.controllers

import com.jonasrosendo.aws_api.domain.dtos.CreateRequestDTO
import com.jonasrosendo.aws_api.domain.models.Request
import com.jonasrosendo.aws_api.domain.usercases.CreateRequestUseCase
import com.jonasrosendo.aws_api.utils.RestConstants.Requests
import jakarta.validation.Valid
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Requests.ROOT_REQUEST_CONTROLLER)
class RequestController(
    private val createRequestUserCase: CreateRequestUseCase
) {

    @PostMapping
    fun save(@RequestBody @Valid createRequestDTO: CreateRequestDTO): ResponseEntity<Request> {

        val request = createRequestUserCase(createRequestDTO = createRequestDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(request)
    }

}