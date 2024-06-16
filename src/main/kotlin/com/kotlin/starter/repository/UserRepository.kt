package com.kotlin.starter.repository

import com.kotlin.starter.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    // select * from users where username = ?
    fun findByUsername(username: String): User?

    // select * from users where email = ?
    fun findByEmail(email: String): User?
}
