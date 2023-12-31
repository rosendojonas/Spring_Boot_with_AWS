package com.jonasrosendo.aws_api.domain.usercases

data class RequestUseCases(
    val createRequestUseCase: CreateRequestUseCase,
    val updateRequestUseCase: UpdateRequestUseCase,
    val getRequestByIdUseCase: GetRequestByIdUseCase,
    val getAllRequestsUseCase: GetAllRequestsUseCase,
    val getAllRequestsByOwnerIdUseCase: GetAllRequestsByOwnerIdUseCase
)