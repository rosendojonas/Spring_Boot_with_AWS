package com.jonasrosendo.aws_api.config

import com.jonasrosendo.aws_api.jwt.JtwAuthenticationEntrypoint
import com.jonasrosendo.aws_api.jwt.JwtAuthorizationFilter
import com.jonasrosendo.aws_api.jwt.JwtUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.*
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.*


@Configuration
@EnableMethodSecurity
@EnableWebMvc
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun filterChain(
        httpSecurity: HttpSecurity,
        userDetailsService: JwtUserDetailsService,
    ): SecurityFilterChain {
        return httpSecurity
            .csrf { csrf -> csrf.disable() }
            .cors { cors -> cors.disable() }
            .formLogin { form -> form.disable() }
            .httpBasic { basic -> basic.disable() }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(HttpMethod.POST, "/api/v1/users").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/v1/auth").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(
                jwtAuthorizationFilter(userDetailsService = userDetailsService),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .exceptionHandling {
                it.authenticationEntryPoint(
                    JtwAuthenticationEntrypoint()
                )
            }.build()
    }

    @Bean
    fun jwtAuthorizationFilter(userDetailsService: JwtUserDetailsService): JwtAuthorizationFilter {
        return JwtAuthorizationFilter(userDetailsService)
    }

    @Bean
    fun bCryptPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }
}