package com.jonasrosendo.aws_api.data.repositories

import com.jonasrosendo.aws_api.domain.models.Request
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestRepository : JpaRepository<Request, Long> {

    fun findAllByOwnerId(id: Long): List<Request>
}