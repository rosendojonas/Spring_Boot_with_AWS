package com.jonasrosendo.aws_api.jwt

import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.models.User
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthorizationFilter(
    private val userDetailsService: JwtUserDetailsService
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val token = request.getHeader(JwtTokenGenerator.JWT_AUTHORIZATION)

        if (token == null || !token.startsWith(JwtTokenGenerator.JWT_BEARER)) {
            logger.info("Jwt is null, empty or not initialized with 'Bearer '.")
            filterChain.doFilter(request, response)
            return
        }

        if (!JwtTokenGenerator.isTokenValid(token)) {
            logger.warn("Jwt token is invalid or expired")
            filterChain.doFilter(request, response)
            return
        }

        val email = JwtTokenGenerator.getEmailFromToken(token)

        authenticate(request, email)

        filterChain.doFilter(request, response)
    }

    private fun authenticate(request: HttpServletRequest, email: String?) {
        val user: UserDetails = userDetailsService.loadUserByUsername(email)

        val authToken =
            UsernamePasswordAuthenticationToken
                .authenticated(
                    userDetailsService,
                    null,
                    user.authorities
                )

        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authToken
    }
}