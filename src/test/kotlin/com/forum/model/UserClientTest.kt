package com.forum.model

import com.forum.models.UserClient

object UserClientTest {

    fun build() = UserClient(
        id = 1,
        name = "Heloisa",
        email = "heloisa@email.com",
        password = "123456"
    )
}