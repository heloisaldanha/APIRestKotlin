package com.forum.services

import com.forum.models.UserClient
import com.forum.respositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun getById(id: Long): UserClient {
        return repository.getReferenceById(id)
    }

}