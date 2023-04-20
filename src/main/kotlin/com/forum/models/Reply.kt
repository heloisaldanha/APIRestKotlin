package com.forum.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Reply(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val user: UserClient,
    @ManyToOne
    val subject: Subject,
    val solved: Boolean
)
