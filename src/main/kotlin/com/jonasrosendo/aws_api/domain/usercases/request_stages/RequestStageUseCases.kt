package com.jonasrosendo.aws_api.domain.usercases.request_stages

import com.jonasrosendo.aws_api.web.controllers.request_stages.UpdateRequestStageStatus

data class RequestStageUseCases(
    val createRequestStageUseCase: CreateRequestStageUseCase,
    val getRequestStageByIdUseCase: GetRequestStageByIdUseCase,
    val getAllRequestStagesByRequestId: GetAllRequestStagesByRequestId,
    val updateRequestStageStatus: UpdateRequestStageStatus
)
