package com.jonasrosendo.aws_api.domain.models

import com.jonasrosendo.aws_api.domain.enums.RequestState
import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "request_stage")
data class RequestStage(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "description", columnDefinition = "text")
    val description: String,
    @Column(name = "realization_date", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    val realizationDate: Date,
    @Column(name = "state", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val state: RequestState,
    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    val request: Request,
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    val owner: User
) : Serializable