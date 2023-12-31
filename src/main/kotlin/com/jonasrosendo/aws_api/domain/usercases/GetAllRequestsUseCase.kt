package com.jonasrosendo.aws_api.domain.usercases

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.domain.models.Request

class GetAllRequestsUseCase(
    private val requestService: RequestService
) {

    operator fun invoke(): List<Request> {
        return requestService.findAll()
    }
}