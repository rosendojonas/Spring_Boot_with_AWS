package com.jonasrosendo.aws_api.domain.usercases.requests

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.domain.models.Request
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class GetAllRequestsUseCase(
    private val requestService: RequestService
) {

    operator fun invoke(pageable: Pageable): Page<Request> {
        return requestService.findAll(pageable)
    }
}