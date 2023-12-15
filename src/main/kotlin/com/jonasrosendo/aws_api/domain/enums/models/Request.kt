package com.jonasrosendo.aws_api.domain.enums.models

import com.jonasrosendo.aws_api.domain.enums.RequestState
import jakarta.persistence.*
import java.io.Serializable
import java.util.Date

@Entity(name = "requests")
@Table(name = "requests")
data class Request(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
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
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    val owner: User,
    @OneToMany(mappedBy = "request")
    val stages: List<RequestStage> = arrayListOf()
) : Serializable