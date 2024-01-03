package com.jonasrosendo.aws_api.data.repositories.requests

import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.Request
import com.jonasrosendo.aws_api.domain.models.RequestStage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface RequestStageRepository : JpaRepository<RequestStage, Long> {

    fun findAllByRequestId(id: Long): List<RequestStage>
}