package com.forum.services

import com.forum.models.UserClient
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val userClient: UserClient) : UserDetails {

    override fun getAuthorities() = userClient.role

    override fun getPassword() = userClient.password

    override fun getUsername() = userClient.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true


}