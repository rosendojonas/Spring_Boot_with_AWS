package com.jonasrosendo.aws_api.di

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.usercases.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCasesDi {

    @Bean
    fun requestRequestUseCases(
        createRequestUseCase: CreateRequestUseCase,
        updateRequestUseCase: UpdateRequestUseCase,
        getRequestByIdUseCase: GetRequestByIdUseCase,
        getAllRequestsUseCase: GetAllRequestsUseCase,
        getAllRequestsByOwnerIdUseCase: GetAllRequestsByOwnerIdUseCase
    ): RequestUseCases {
        return RequestUseCases(
            createRequestUseCase = createRequestUseCase,
            updateRequestUseCase = updateRequestUseCase,
            getRequestByIdUseCase = getRequestByIdUseCase,
            getAllRequestsUseCase = getAllRequestsUseCase,
            getAllRequestsByOwnerIdUseCase = getAllRequestsByOwnerIdUseCase
        )
    }

    @Bean
    fun createRequestUseCase(requestService: RequestService, userService: UserService): CreateRequestUseCase {
        return CreateRequestUseCase(
            requestService = requestService,
            userService = userService
        )
    }

    @Bean
    fun updateRequestUseCase(requestService: RequestService, userService: UserService): UpdateRequestUseCase {
        return UpdateRequestUseCase(
            requestService = requestService,
            userService = userService
        )
    }

    @Bean
    fun getRequestByIdUseCase(requestService: RequestService): GetRequestByIdUseCase {
        return GetRequestByIdUseCase(requestService)
    }

    @Bean
    fun getAllRequestsUseCase(requestService: RequestService): GetAllRequestsUseCase {
        return GetAllRequestsUseCase(requestService)
    }

    @Bean
    fun getAllRequestsByOwnerIdUseCase(requestService: RequestService): GetAllRequestsByOwnerIdUseCase {
        return GetAllRequestsByOwnerIdUseCase(requestService)
    }

}