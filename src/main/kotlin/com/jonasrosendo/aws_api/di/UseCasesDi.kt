package com.jonasrosendo.aws_api.di

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.usercases.CreateRequestUseCase
import com.jonasrosendo.aws_api.domain.usercases.RequestUseCases
import com.jonasrosendo.aws_api.domain.usercases.UpdateRequestUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCasesDi {

    @Bean
    fun requestRequestUseCases(
        createRequestUseCase: CreateRequestUseCase,
        updateRequestUseCase: UpdateRequestUseCase,
    ): RequestUseCases {
        return RequestUseCases(
            createRequestUseCase = createRequestUseCase,
            updateRequestUseCase = updateRequestUseCase
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
}