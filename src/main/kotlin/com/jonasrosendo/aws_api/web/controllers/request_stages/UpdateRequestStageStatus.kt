package com.jonasrosendo.aws_api.web.controllers.request_stages

import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.domain.dtos.request_stages.UpdateRequestStageDTO
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.RequestStage

class UpdateRequestStageStatus(
    private val requestStageService: RequestStageService,
) {

    operator fun invoke(updateRequestStageDTO: UpdateRequestStageDTO): RequestStage {
        return requestStageService.updateStatus(
            updateRequestStageDTO.id,
            RequestState.valueOf(updateRequestStageDTO.status)
        )
    }
}