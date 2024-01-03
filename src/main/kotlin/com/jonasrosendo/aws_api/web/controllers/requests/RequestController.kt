package com.jonasrosendo.aws_api.web.controllers.requests

import com.jonasrosendo.aws_api.domain.dtos.requests.CreateRequestDTO
import com.jonasrosendo.aws_api.domain.dtos.requests.UpdateRequestDTO
import com.jonasrosendo.aws_api.domain.models.Request
import com.jonasrosendo.aws_api.domain.usercases.requests.RequestUseCases
import com.jonasrosendo.aws_api.utils.RestConstants.Requests
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Requests.ROOT_REQUEST_CONTROLLER)
class RequestController(
    private val useCases: RequestUseCases,
) {

    @PostMapping
    fun save(
        @RequestBody @Valid createRequestDTO: CreateRequestDTO,
    ): ResponseEntity<Request> {

        val request = useCases.createRequestUseCase(createRequestDTO = createRequestDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(request)
    }

    @PatchMapping("/{id}")
    fun update(
        @RequestBody updateRequestDTO: UpdateRequestDTO,
        @PathVariable id: Long,
    ): ResponseEntity<Request> {

        val request = useCases.updateRequestUseCase(updateRequestDTO, id)
        return ResponseEntity.ok(request)
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long,
    ): ResponseEntity<Request> {

        val request = useCases.getRequestByIdUseCase(id)
        return ResponseEntity.ok(request)
    }

    @GetMapping
    fun findAll(
        @PageableDefault(size = 5) pageable: Pageable
    ): ResponseEntity<Page<Request>> {
        val requests = useCases.getAllRequestsUseCase(pageable)
        return ResponseEntity.ok(requests)
    }

    @GetMapping("/owner/{id}")
    fun findAllByOwnerId(
        @PathVariable id: Long,
        @PageableDefault(size = 5) pageable: Pageable
    ): ResponseEntity<Page<Request>> {
        val requests = useCases.getAllRequestsByOwnerIdUseCase(id, pageable)
        return ResponseEntity.ok(requests)
    }
}