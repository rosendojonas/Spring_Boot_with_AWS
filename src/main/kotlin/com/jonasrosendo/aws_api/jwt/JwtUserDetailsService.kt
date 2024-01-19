package com.jonasrosendo.aws_api.jwt

import com.jonasrosendo.aws_api.data.repositories.users.UserRepository
import com.jonasrosendo.aws_api.domain.enums.Role
import com.jonasrosendo.aws_api.domain.models.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService{

    override fun loadUserByUsername(email: String?): UserDetails {
        val user: User? = userRepository.findByEmail(email = email)
        return if (user != null) JwtUser(user)
        else throw UsernameNotFoundException("not possible to find user = '$email'")
    }

    fun getAuthenticatedToken(email: String): JwtToken {
        val role: Role = userRepository.findByEmail(email)?.role!!
        return JwtTokenGenerator.createToken(email, role.name)
    }
}