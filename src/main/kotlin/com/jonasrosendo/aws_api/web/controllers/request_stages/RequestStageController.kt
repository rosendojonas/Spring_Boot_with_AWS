package com.jonasrosendo.aws_api.web.controllers.request_stages

import com.jonasrosendo.aws_api.domain.dtos.request_stages.CreateRequestStageDTO
import com.jonasrosendo.aws_api.domain.models.RequestStage
import com.jonasrosendo.aws_api.domain.usercases.request_stages.RequestStageUseCases
import com.jonasrosendo.aws_api.utils.RestConstants.RequestStages
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(RequestStages.ROOT_REQUEST_STAGE_CONTROLLER)
class RequestStageController(
    private val requestStageUseCases: RequestStageUseCases
) {

    @PostMapping
    fun save(@RequestBody @Valid createRequestStageDTO: CreateRequestStageDTO): ResponseEntity<RequestStage> {
        val requestStage = requestStageUseCases.createRequestStageUseCase(createRequestStageDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(requestStage)
    }


}