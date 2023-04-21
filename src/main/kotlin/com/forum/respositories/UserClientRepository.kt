package com.forum.respositories

import com.forum.models.UserClient
import org.springframework.data.jpa.repository.JpaRepository

interface UserClientRepository: JpaRepository<UserClient, Long> {

    fun findByEmail(username: String?): UserClient?
}