package com.forum.services

import com.forum.models.UserClient
import com.forum.respositories.UserClientRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserClientService(private val repository: UserClientRepository): UserDetailsService {

    fun getById(id: Long): UserClient {
        return repository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val userClient = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(userClient)
    }

}