package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.requests.RequestFileRepository
import com.jonasrosendo.aws_api.domain.models.RequestFile
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RequestFileService(
    private val repository: RequestFileRepository
) {

    //upload

    fun listALlByRequestId(id: Long, pageable: Pageable): Page<List<RequestFile>> {
        return repository.findAllByRequestId(id, pageable)
    }
}