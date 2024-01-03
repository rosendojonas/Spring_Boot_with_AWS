package com.jonasrosendo.aws_api.di

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.domain.usercases.request_stages.CreateRequestStageUseCase
import com.jonasrosendo.aws_api.domain.usercases.request_stages.GetRequestStageByIdUseCase
import com.jonasrosendo.aws_api.domain.usercases.request_stages.RequestStageUseCases
import com.jonasrosendo.aws_api.domain.usercases.request_stages.GetAllRequestStagesByRequestId
import com.jonasrosendo.aws_api.domain.usercases.request_stages.UpdateRequestStageStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RequestStageUseCasesDi {

    @Bean
    fun requestStagesUseCases(
        createRequestStageUseCase: CreateRequestStageUseCase,
        getRequestStageByIdUseCase: GetRequestStageByIdUseCase,
        updateRequestStageStatus: UpdateRequestStageStatus,
        getAllRequestStagesByRequestId: GetAllRequestStagesByRequestId
    ): RequestStageUseCases {
        return RequestStageUseCases(
            createRequestStageUseCase = createRequestStageUseCase,
            getRequestStageByIdUseCase = getRequestStageByIdUseCase,
            updateRequestStageStatus = updateRequestStageStatus,
            getAllRequestStagesByRequestId = getAllRequestStagesByRequestId
        )
    }

    @Bean
    fun createRequestStageUseCase(requestStageService: RequestStageService, requestService: RequestService): CreateRequestStageUseCase {
        return CreateRequestStageUseCase(
            requestStageService = requestStageService,
            requestService = requestService
        )
    }

    @Bean
    fun getRequestStageByIdUseCase(requestStageService: RequestStageService): GetRequestStageByIdUseCase {
        return GetRequestStageByIdUseCase(requestStageService = requestStageService)
    }

    @Bean
    fun getAllRequestStagesByRequestId(requestStageService: RequestStageService): GetAllRequestStagesByRequestId {
        return GetAllRequestStagesByRequestId(requestStageService = requestStageService)
    }

    @Bean
    fun updateRequestStageStatus(requestStageService: RequestStageService): UpdateRequestStageStatus {
        return UpdateRequestStageStatus(requestStageService = requestStageService)
    }

}