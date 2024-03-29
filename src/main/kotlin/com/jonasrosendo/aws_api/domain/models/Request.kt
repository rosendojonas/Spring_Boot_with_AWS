package com.jonasrosendo.aws_api.domain.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.jonasrosendo.aws_api.domain.enums.RequestState
import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "requests")
data class Request(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "subject", length = 75, nullable = false)
    val subject :String,
    @Column(name = "description", columnDefinition = "text")
    val description: String,
    @Column(name = "created_at", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    val creationAt: Date,
    @Column(name = "state", length = 12, nullable = false)
    @Enumerated(value = EnumType.STRING)
    val state: RequestState,
    @get:JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    val owner: User,
    @OneToMany(mappedBy = "request")
    val stages: List<RequestStage> = arrayListOf(),
    @OneToMany(mappedBy = "request")
    val files: List<RequestFile> = arrayListOf()

) : Serializable