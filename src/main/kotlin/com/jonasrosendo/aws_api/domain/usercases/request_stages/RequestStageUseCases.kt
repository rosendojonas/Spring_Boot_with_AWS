package com.jonasrosendo.aws_api.domain.usercases.request_stages

data class RequestStageUseCases(
    val createRequestStageUseCase: CreateRequestStageUseCase,
    val getRequestStageByIdUseCase: GetRequestStageByIdUseCase,
    val getAllRequestStagesByRequestId: GetAllRequestStagesByRequestId,
    val updateRequestStageStatus: UpdateRequestStageStatus
)
