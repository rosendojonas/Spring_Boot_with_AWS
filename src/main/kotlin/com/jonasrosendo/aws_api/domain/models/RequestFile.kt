package com.jonasrosendo.aws_api.domain.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "request_files")
data class RequestFile(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(length = 100, nullable = false)
    val name: String,
    @Column(columnDefinition = "text", nullable = false)
    val url: String,
    @get:JsonIgnore
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    val request: Request
) : Serializable