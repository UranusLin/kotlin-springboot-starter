package com.kotlin.starter.repository

import com.kotlin.starter.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
