package com.forum.services

import com.forum.models.User
import org.springframework.stereotype.Service

@Service
class UserService(var users: List<User>) {
    init {
        val user = User(
            id = 1,
            name = "Heloísa",
            email = "heloisa@email.com"
        )

        users = listOf(user)
    }

    fun getById(id: Long): User {
        val userById = users.stream().filter { user ->
            user.id == id
        }.findFirst().get()

        return userById
    }

}