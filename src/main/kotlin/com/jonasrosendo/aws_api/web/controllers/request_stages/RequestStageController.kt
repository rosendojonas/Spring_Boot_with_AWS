package com.jonasrosendo.aws_api.web.controllers.request_stages

import com.jonasrosendo.aws_api.domain.dtos.request_stages.CreateRequestStageDTO
import com.jonasrosendo.aws_api.domain.dtos.request_stages.UpdateRequestStageDTO
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.RequestStage
import com.jonasrosendo.aws_api.domain.usercases.request_stages.RequestStageUseCases
import com.jonasrosendo.aws_api.utils.RestConstants.RequestStages
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(RequestStages.ROOT_REQUEST_STAGE_CONTROLLER)
class RequestStageController(
    private val requestStageUseCases: RequestStageUseCases,
) {

    @PostMapping
    fun save(@RequestBody @Valid createRequestStageDTO: CreateRequestStageDTO): ResponseEntity<RequestStage> {
        val requestStage = requestStageUseCases.createRequestStageUseCase(createRequestStageDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(requestStage)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<RequestStage> {
        val requestStage = requestStageUseCases.getRequestStageByIdUseCase(id)
        return ResponseEntity.ok(requestStage)
    }

    @GetMapping("/request/{id}")
    fun findAllByRequestId(@PathVariable id: Long): ResponseEntity<List<RequestStage>> {
        val requestStages = requestStageUseCases.getAllRequestStagesByRequestId(id)
        return ResponseEntity.ok(requestStages)
    }

    @PatchMapping
    fun updateStatus(@RequestBody updateRequestStageDTO: UpdateRequestStageDTO): ResponseEntity<RequestStage> {
        val updatedRequestStageStatus = requestStageUseCases.updateRequestStageStatus(updateRequestStageDTO)
        return ResponseEntity.ok(updatedRequestStageStatus)
    }
}