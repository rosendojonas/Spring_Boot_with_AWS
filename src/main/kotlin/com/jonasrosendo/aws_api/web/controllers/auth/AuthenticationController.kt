package com.jonasrosendo.aws_api.web.controllers.auth

import com.jonasrosendo.aws_api.domain.dtos.auth.UserAuthenticationDTO
import com.jonasrosendo.aws_api.exceptions.ApiException
import com.jonasrosendo.aws_api.jwt.JwtUserDetailsService
import com.jonasrosendo.aws_api.utils.RestConstants
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(RestConstants.Auth.ROOT_AUTH_CONTROLLER)
class AuthenticationController(
    private val jwtUserDetailsService: JwtUserDetailsService,
    private val authenticationManager: AuthenticationManager
) {

    @PostMapping
    fun authenticate(
        @RequestBody @Valid userAuthenticationDTO: UserAuthenticationDTO,
        request: HttpServletRequest,
    ): ResponseEntity<*> {
        try {
            val usernamePasswordAuthenticationToken =
                UsernamePasswordAuthenticationToken(
                    userAuthenticationDTO.email,
                    userAuthenticationDTO.password
                )

            authenticationManager.authenticate(usernamePasswordAuthenticationToken)
            val token = jwtUserDetailsService.getAuthenticatedToken(userAuthenticationDTO.email)
            return ResponseEntity.ok(token)
        } catch (e: AuthenticationException) {
            e.printStackTrace()
        }

        return ResponseEntity
            .badRequest()
            .body(
                ApiException(
                    code = HttpStatus.BAD_REQUEST.value(),
                    message = "invalid credentials",
                    internalCode = ""
                )
            )
    }
}