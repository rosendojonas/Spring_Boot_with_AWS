package com.jonasrosendo.aws_api.domain.usercases.request_stages

import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.domain.models.RequestStage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class GetAllRequestStagesByRequestId(
    private val requestStageService: RequestStageService,
) {

    operator fun invoke(id: Long, pageable: Pageable): Page<RequestStage> {
        return requestStageService.findAllByRequestId(id, pageable = pageable)
    }
}