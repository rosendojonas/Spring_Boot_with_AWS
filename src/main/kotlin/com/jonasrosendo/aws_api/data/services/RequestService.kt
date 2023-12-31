package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.RequestRepository
import com.jonasrosendo.aws_api.data.repositories.UserRepository
import com.jonasrosendo.aws_api.domain.models.Request
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class RequestService(
    private val requestRepository: RequestRepository
) {

    fun save(
        request: Request,
    ): Request {
        val savedRequest = requestRepository.save(request)
        return savedRequest
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