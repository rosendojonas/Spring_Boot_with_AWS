package com.jonasrosendo.aws_api.domain.usercases

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.domain.models.Request

class GetRequestByIdUseCase(
    private val requestService: RequestService
) {

    operator fun invoke(id: Long): Request {
        return requestService.findById(id);
    }
}
