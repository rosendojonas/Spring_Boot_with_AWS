package com.jonasrosendo.aws_api.data.repositories.users

import com.jonasrosendo.aws_api.domain.enums.Role
import com.jonasrosendo.aws_api.domain.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String?): User?
}