package com.jonasrosendo.aws_api.jwt

import com.jonasrosendo.aws_api.domain.models.User
import org.springframework.security.core.authority.AuthorityUtils

data class JwtUser(
    val user: User,
) : org.springframework.security.core.userdetails.User
    (user.email, user.password, AuthorityUtils.createAuthorityList(user.role.name))