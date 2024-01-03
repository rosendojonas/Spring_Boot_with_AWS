package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.requests.RequestRepository
import com.jonasrosendo.aws_api.domain.models.Request
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RequestService(
    private val requestRepository: RequestRepository
) {

    fun save(
        request: Request,
    ): Request {
        return requestRepository.save(request)
    }

    fun update(request: Request): Request {
        return requestRepository.save(request)
    }

    fun findById(id: Long): Request {
        return requestRepository.findById(id).orElseThrow {
            throw EntityNotFoundException("request with id='$id' does not exist.")
        }
    }

    fun findAll(pageable: Pageable): Page<Request> {
        return requestRepository.findAll(pageable)
    }

    fun findAllByOwner(ownerId: Long, pageable: Pageable): Page<Request> {
        return requestRepository.findAllByOwnerId(ownerId = ownerId, pageable)
    }
}