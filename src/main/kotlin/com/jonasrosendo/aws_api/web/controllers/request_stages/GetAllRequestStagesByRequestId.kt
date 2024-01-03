package com.jonasrosendo.aws_api.web.controllers.request_stages

import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.domain.models.RequestStage

class GetAllRequestStagesByRequestId(
    private val requestStageService: RequestStageService,
) {

    operator fun invoke(id: Long): List<RequestStage> {
        return requestStageService.findAllByRequestId(id)
    }
}