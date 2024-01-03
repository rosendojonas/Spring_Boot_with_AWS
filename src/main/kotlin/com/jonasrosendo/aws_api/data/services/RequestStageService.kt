package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.requests.RequestStageRepository
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.RequestStage
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class RequestStageService(
    private val requestStageRepository: RequestStageRepository,
) {

    fun save(requestStage: RequestStage): RequestStage {
        return requestStageRepository.save(requestStage.copy(realizationDate = Date()))
    }

    fun findById(id: Long): RequestStage {
        return requestStageRepository.findById(id).orElseThrow {
            throw EntityNotFoundException("request stage with id='$id' does not exist.")
        }
    }

    fun findAllByRequestId(id: Long): List<RequestStage> {
        return requestStageRepository.findAllByRequestId(id = id)
    }

    fun updateStatus(id: Long, state: RequestState): RequestStage {
        val currentRequestStage = requestStageRepository.findById(id).orElseThrow {
            throw EntityNotFoundException("Could not find request stage with id='$id'")
        }

        val updatedRequestStage = currentRequestStage.copy(state = state)
        return requestStageRepository.save(updatedRequestStage)
    }
}