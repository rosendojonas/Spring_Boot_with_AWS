package com.jonasrosendo.aws_api.domain.usercases

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.domain.models.Request

class GetAllRequestsByOwnerIdUseCase(
    private val requestService: RequestService
) {

    operator fun invoke(ownerId: Long): List<Request> {
        return requestService.findAllByOwner(ownerId)
    }
}