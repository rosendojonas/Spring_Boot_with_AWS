package com.jonasrosendo.aws_api.data.services

import com.jonasrosendo.aws_api.data.repositories.users.UserRepository
import com.jonasrosendo.aws_api.domain.models.User
import jakarta.persistence.EntityNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.security.auth.login.CredentialException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: PasswordEncoder,
) {

    fun saveUser(user: User): User {
        val encryptedPassword = bCryptPasswordEncoder.encode(user.password)
        val userWithEncryptedPassword = user.copy(password = encryptedPassword)
        return userRepository.save(userWithEncryptedPassword)
    }

    fun updateUser(user: User): User {
        val updatedUser = userRepository.save(
            user.copy(
                password = bCryptPasswordEncoder.encode(user.password)
            )
        )
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

    fun findUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun login(email: String, password: String): User {
        val user = findUserByEmail(email)

        val isCredentialValid = user?.let {
            bCryptPasswordEncoder.matches(password, user.password)
        } ?: false

        return if (isCredentialValid) user!! else throw CredentialException("Invalid Credentials")

    }
}