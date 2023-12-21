package com.jonasrosendo.aws_api.web.controllers

import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.UserResponse
import com.jonasrosendo.aws_api.domain.dtos.LoginDTO
import com.jonasrosendo.aws_api.domain.dtos.UserDTO
import com.jonasrosendo.aws_api.domain.enums.Role
import com.jonasrosendo.aws_api.domain.models.User
import com.jonasrosendo.aws_api.web.mapper.toResponse
import com.jonasrosendo.aws_api.web.mapper.toUser
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping
    fun create(@RequestBody userDTO: UserDTO): ResponseEntity<UserResponse> {
        val user = userDTO.toUser()
        val savedUser = userService.saveUser(user)
        return ResponseEntity(savedUser.toResponse(), HttpStatus.CREATED)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDTO: LoginDTO): ResponseEntity<User> {
        val loggedUser = userService.login(loginDTO.email, loginDTO.password)
        return ResponseEntity.ok(loggedUser)
    }

}