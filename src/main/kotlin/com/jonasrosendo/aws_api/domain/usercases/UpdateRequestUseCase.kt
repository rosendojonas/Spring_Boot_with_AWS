package com.jonasrosendo.aws_api.domain.usercases

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.dtos.requests.UpdateRequestDTO
import com.jonasrosendo.aws_api.domain.models.Request

class UpdateRequestUseCase(
    private val requestService: RequestService,
    private val userService: UserService
) {

    operator fun invoke(updateRequestDTO: UpdateRequestDTO, id: Long): Request {
        val currentRequest = requestService.findById(id)
        val currentOwner = currentRequest.owner

        val newOwner = if (currentOwner.email != updateRequestDTO.ownerEmail) {
            userService.findUserByEmail(email = updateRequestDTO.ownerEmail)
        } else {
            null
        }

        val updatedRequest =
            currentRequest.copy(
                subject = updateRequestDTO.subject,
                description = updateRequestDTO.description ?: "",
                owner = newOwner ?: currentOwner,
                state = updateRequestDTO.state
            )

        return requestService.update(updatedRequest)
    }
}