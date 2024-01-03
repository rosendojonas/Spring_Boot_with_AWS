package com.jonasrosendo.aws_api.data.repositories.requests

import com.jonasrosendo.aws_api.domain.models.Request
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestRepository : JpaRepository<Request, Long> {

    fun findAllByOwnerId(ownerId: Long, pageable: Pageable): Page<Request>
}