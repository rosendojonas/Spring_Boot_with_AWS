package com.jonasrosendo.aws_api.domain.enums.models

import com.jonasrosendo.aws_api.domain.enums.Role
import jakarta.persistence.*

@Entity(name = "users")
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "name", length = 75, nullable = false)
    val name: String,
    @Column(name = "email", length = 75, nullable = false, unique = true)
    val email: String,
    @Column(name = "password", length = 100, nullable = false)
    val password: String,
    @Column(name = "role", length = 20, nullable = false)
    @Enumerated(value = EnumType.STRING)
    val role: Role,
    @OneToMany(mappedBy = "user")
    val requests: List<Request> = arrayListOf(),
    @OneToMany(mappedBy = "user")
    val stages: List<RequestStage> = arrayListOf()
)