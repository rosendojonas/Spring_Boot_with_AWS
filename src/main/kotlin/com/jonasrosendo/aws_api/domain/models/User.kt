package com.jonasrosendo.aws_api.domain.models

import com.jonasrosendo.aws_api.domain.enums.Role
import jakarta.persistence.*
import java.io.Serializable

@Entity(name = "users")
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "name", length = 75, nullable = false)
    val name: String,
    @Column(name = "email", length = 75, nullable = false, unique = true)
    val email: String,
    @Column(name = "password", length = 100, nullable = false)
    val password: String,
    @Column(name = "role", length = 20, nullable = false)
    @Enumerated(value = EnumType.STRING)
    val role: Role,
    @OneToMany(mappedBy = "owner")
    val requests: List<Request> = arrayListOf(),
    @OneToMany(mappedBy = "owner")
    val stages: List<RequestStage> = arrayListOf()
) : Serializable