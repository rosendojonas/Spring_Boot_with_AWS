package com.jonasrosendo.aws_api.data.repositories.requests

import com.jonasrosendo.aws_api.domain.models.RequestFile
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestFileRepository : JpaRepository<RequestFile, Long> {

    fun findAllByRequestId(id: Long, pageable: Pageable): Page<List<RequestFile>>
}