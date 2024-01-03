package com.jonasrosendo.aws_api.domain.usercases.request_stages

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.domain.dtos.request_stages.CreateRequestStageDTO
import com.jonasrosendo.aws_api.domain.models.RequestStage
import com.jonasrosendo.aws_api.web.mapper.toRequestStage

class CreateRequestStageUseCase(
    private val requestStageService: RequestStageService,
    private val requestService: RequestService,
) {

    operator fun invoke(createRequestStageDTO: CreateRequestStageDTO): RequestStage {

        val request = requestService.findById(createRequestStageDTO.requestId)
        val requestStage = createRequestStageDTO.toRequestStage(request = request)
        return requestStageService.save(requestStage)
    }
}