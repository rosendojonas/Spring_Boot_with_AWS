package com.jonasrosendo.aws_api.di

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.RequestStageService
import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.usercases.request_stages.CreateRequestStageUseCase
import com.jonasrosendo.aws_api.domain.usercases.request_stages.RequestStageUseCases
import com.jonasrosendo.aws_api.domain.usercases.requests.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RequestStageUseCasesDi {

    @Bean
    fun requestStagesUseCases(
        createRequestStageUseCase: CreateRequestStageUseCase
    ): RequestStageUseCases {
        return RequestStageUseCases(
            createRequestStageUseCase = createRequestStageUseCase,
        )
    }

    @Bean
    fun createRequestStageUseCase(requestStageService: RequestStageService, requestService: RequestService): CreateRequestStageUseCase {
        return CreateRequestStageUseCase(
            requestStageService = requestStageService,
            requestService = requestService
        )
    }

}