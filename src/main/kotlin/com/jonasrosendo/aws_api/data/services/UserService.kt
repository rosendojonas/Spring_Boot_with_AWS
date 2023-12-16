package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.UserRepository
import com.jonasrosendo.aws_api.domain.models.User
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import javax.security.auth.login.CredentialException

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun saveUser(user: User): User {
        val createdUser = userRepository.save(user)
        return createdUser
    }

    fun updateUser(user: User): User {
        val updatedUser = userRepository.save(user)
        return updatedUser
    }

    fun getUserById(id: Long): User? {
        val user = userRepository.findById(id).orElseThrow {
            throw EntityNotFoundException("User with id='$id' does not exist.")
        }

        return user
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun login(email: String, password: String): User {
        val user = userRepository.login(email = email, password = password) ?: throw CredentialException()
        return user
    }
}