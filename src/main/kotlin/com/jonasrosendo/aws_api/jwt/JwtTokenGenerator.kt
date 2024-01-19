package com.jonasrosendo.aws_api.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.nio.charset.StandardCharsets
import java.time.ZoneId
import java.util.*
import javax.crypto.SecretKey

object JwtTokenGenerator {

    const val JWT_BEARER = "Bearer "
    const val JWT_AUTHORIZATION: String = "Authorization"
    const val SECRET_KEY: String = "1234567890.1234567890.1234567890"
    const val EXPIRE_DAYS: Long = 0
    const val EXPIRE_HOURS: Long = 0
    const val EXPIRE_MINUTES: Long = 30

    private fun generateKey(): SecretKey? {
        return Keys.hmacShaKeyFor(SECRET_KEY.toByteArray(StandardCharsets.UTF_8))
    }

    private fun toExpirationDate(start: Date): Date {
        val startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        val endDate = startDate.plusDays(EXPIRE_DAYS).plusHours(EXPIRE_HOURS).plusMinutes(EXPIRE_MINUTES)

        return Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant())

    }

    fun createToken(email: String, role: String): JwtToken {

        val issuedAt = Date()
        val expiration = toExpirationDate(issuedAt)

        val token = Jwts.builder()
            .header().add("typ", "JWT").and()
            .subject(email)
            .issuedAt(issuedAt)
            .expiration(expiration)
            .signWith(generateKey(), Jwts.SIG.HS256)
            .claim("role", role)
            .compact()

        return JwtToken(token)
    }

    private fun getClaimsFromToken(token: String): Claims? {
        return try {
            Jwts.parser()
                .verifyWith(generateKey() as SecretKey)
                .build()
                .parseSignedClaims(refactorToken(token)).payload
        } catch (ex: JwtException) {
            ex.printStackTrace()
            null
        }
    }

    private fun refactorToken(token: String): String {
        if (token.contains(JWT_BEARER)) {
            return token.substring(JWT_BEARER.length)
        }

        return token
    }

    fun isTokenValid(token: String): Boolean {
        try {
            Jwts.parser()
                .verifyWith(generateKey() as SecretKey)
                .build()
                .parseSignedClaims(refactorToken(token))
            return true
        } catch (ex: JwtException) {
            ex.printStackTrace()
        }

        return false
    }

    fun getEmailFromToken(token: String): String? {
        return getClaimsFromToken(token)?.subject

    }
}