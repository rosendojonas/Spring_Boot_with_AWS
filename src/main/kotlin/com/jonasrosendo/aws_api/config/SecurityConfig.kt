package com.jonasrosendo.aws_api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig {


    @Bean
    fun bCrypt(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}