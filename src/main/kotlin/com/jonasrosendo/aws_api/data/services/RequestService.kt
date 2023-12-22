package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.RequestRepository
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.Request
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class RequestService(
    private val requestRepository: RequestRepository,
) {

    fun save(request: Request): Request {
        val openedRequest = request.copy(state = RequestState.OPEN, creationAt = Date())
        return requestRepository.save(openedRequest)
    }

    fun update(request: Request): Request {
        return requestRepository.save(request)
    }

    fun findById(id: Long): Request {
        return requestRepository.findById(id).orElseThrow {
            throw EntityNotFoundException("request with id='$id' does not exist.")
        }
    }

    fun findAll(): List<Request> {
        return requestRepository.findAll()
    }

    fun findAllByOwner(ownerId: Long): List<Request> {
        return requestRepository.findAllByOwnerId(ownerId = ownerId)
    }
}