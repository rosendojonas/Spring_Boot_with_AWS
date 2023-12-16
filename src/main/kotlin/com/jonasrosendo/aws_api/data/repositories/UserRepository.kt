package com.jonasrosendo.aws_api.data.repositories

import com.jonasrosendo.aws_api.domain.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    @Query("SELECT FROM User WHERE email = :email AND password = :password")
    fun login(email: String, password: String): User?
}