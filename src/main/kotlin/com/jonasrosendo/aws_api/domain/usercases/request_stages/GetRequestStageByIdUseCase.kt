package com.jonasrosendo.aws_api.domain.usercases.request_stages

import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.domain.models.RequestStage

class GetRequestStageByIdUseCase(
    private val requestStageService: RequestStageService
) {

    operator fun invoke(id: Long): RequestStage {
        return requestStageService.findById(id)
    }
}