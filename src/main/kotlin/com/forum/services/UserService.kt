package com.forum.services

import com.forum.models.User
import com.forum.respositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun getById(id: Long): User {
        return repository.getReferenceById(id)
    }

}