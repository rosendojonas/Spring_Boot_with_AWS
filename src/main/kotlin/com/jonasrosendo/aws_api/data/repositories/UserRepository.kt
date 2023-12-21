package com.jonasrosendo.aws_api.data.repositories

import com.jonasrosendo.aws_api.domain.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findUserByEmail(email: String): User?
}