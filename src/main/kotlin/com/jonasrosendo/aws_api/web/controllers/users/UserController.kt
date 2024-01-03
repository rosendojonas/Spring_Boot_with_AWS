package com.jonasrosendo.aws_api.web.controllers.users

import com.jonasrosendo.aws_api.data.services.UserService
import com.jonasrosendo.aws_api.domain.dtos.users.LoginDTO
import com.jonasrosendo.aws_api.domain.dtos.users.UpdateUserRoleDTO
import com.jonasrosendo.aws_api.domain.dtos.users.UserDTO
import com.jonasrosendo.aws_api.domain.enums.Role
import com.jonasrosendo.aws_api.domain.models.User
import com.jonasrosendo.aws_api.domain.responses.UserResponse
import com.jonasrosendo.aws_api.utils.RestConstants.Users
import com.jonasrosendo.aws_api.web.mapper.toResponse
import com.jonasrosendo.aws_api.web.mapper.toUser
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Users.ROOT_USER_CONTROLLER)
class UserController(
    private val userService: UserService,
) {

    @PostMapping
    fun create(@RequestBody userDTO: UserDTO): ResponseEntity<UserResponse> {
        val user = userDTO.toUser()
        val savedUser = userService.saveUser(user)
        return ResponseEntity(savedUser.toResponse(), HttpStatus.CREATED)
    }

    @PostMapping(Users.LOGIN_PATH)
    fun login(@RequestBody loginDTO: LoginDTO): ResponseEntity<User> {
        val loggedUser = userService.login(loginDTO.email, loginDTO.password)
        return ResponseEntity.ok(loggedUser)
    }

    @PatchMapping
    fun updateRole(
        @RequestBody updateUserDTO: UpdateUserRoleDTO,
    ) {
        val currentUser = userService.getUserById(updateUserDTO.id)

        currentUser?.let {
            userService.updateUser(it.copy(role = Role.valueOf(updateUserDTO.role)))
        }
    }
}