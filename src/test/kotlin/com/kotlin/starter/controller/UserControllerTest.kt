package com.kotlin.starter.controller

import com.kotlin.starter.config.TestSecurityConfig
import com.kotlin.starter.model.User
import com.kotlin.starter.service.UserService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(UserController::class)
@ActiveProfiles("test")
@Import(TestSecurityConfig::class)
class UserControllerTest(
    @Autowired val mockMvc: MockMvc,
) {
    @MockBean
    private lateinit var userService: UserService

    @Test
    fun `should return all users`() {
        val users = listOf(User(1, "user1", "user1@example.com"), User(2, "user2", "user2@example.com"))
        Mockito.`when`(userService.getAllUsers()).thenReturn(users)

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/users"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(users.size))
    }
}
