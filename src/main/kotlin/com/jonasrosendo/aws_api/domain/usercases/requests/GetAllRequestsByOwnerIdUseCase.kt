package com.jonasrosendo.aws_api.domain.usercases.requests

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.domain.models.Request
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class GetAllRequestsByOwnerIdUseCase(
    private val requestService: RequestService
) {

    operator fun invoke(ownerId: Long, pageable: Pageable): Page<Request> {
        return requestService.findAllByOwner(ownerId, pageable)
    }
}