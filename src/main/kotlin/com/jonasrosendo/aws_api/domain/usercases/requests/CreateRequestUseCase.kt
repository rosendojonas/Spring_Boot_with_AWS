package com.jonasrosendo.aws_api.domain.usercases.requests

import com.jonasrosendo.aws_api.data.services.RequestService
import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.dtos.requests.CreateRequestDTO
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.Request
import com.jonasrosendo.aws_api.web.mapper.toRequest
import java.util.*

class CreateRequestUseCase(
    private val requestService: RequestService,
    private val userService: UserService,
) {
    operator fun invoke(createRequestDTO: CreateRequestDTO): Request {
        val owner = userService.findUserByEmail(createRequestDTO.ownerEmail)

        val request = createRequestDTO.toRequest(
            state = RequestState.OPEN,
            creationAt = Date(),
            owner = owner!!
        )

        return requestService.save(request)
    }
}
