package com.forum.respositories

import com.forum.models.UserClient
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserClient, Long> {
}