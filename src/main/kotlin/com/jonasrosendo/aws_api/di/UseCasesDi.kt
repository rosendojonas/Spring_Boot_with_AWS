package com.jonasrosendo.aws_api.di

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.usercases.CreateRequestUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCasesDi {

    @Bean
    fun createRequestUseCase(requestService: RequestService, userService: UserService): CreateRequestUseCase {
        return CreateRequestUseCase(
            requestService = requestService,
            userService = userService
        )
    }
}