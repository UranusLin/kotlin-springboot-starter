package com.kotlin.starter.service

import com.kotlin.starter.model.User
import com.kotlin.starter.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User = userRepository.findById(id).orElseThrow { Exception("User not found") }

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(
        id: Long,
        updatedUser: User,
    ): User {
        val user = userRepository.findById(id).orElseThrow { Exception("User not found") }
        val newUser = user.copy(username = updatedUser.username, email = updatedUser.email)
        return userRepository.save(newUser)
    }

    fun deleteUser(id: Long) = userRepository.deleteById(id)
}
