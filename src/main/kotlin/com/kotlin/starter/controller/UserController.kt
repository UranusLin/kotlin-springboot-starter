@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.kotlin.starter.controller

import com.kotlin.starter.dto.UserDto
import com.kotlin.starter.model.User
import com.kotlin.starter.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping
    fun getAllUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Long,
    ): User = userService.getUserById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(
        @RequestBody userDto: UserDto,
    ): User {
        val user = User(username = userDto.username, email = userDto.email)
        return userService.createUser(user)
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody userDto: UserDto,
    ): User {
        val user = User(id = id, username = userDto.username, email = userDto.email)
        return userService.updateUser(id, user)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(
        @PathVariable id: Long,
    ) = userService.deleteUser(id)
}
