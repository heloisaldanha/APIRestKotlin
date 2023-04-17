package com.forum.models

import java.time.LocalDateTime

data class Reply(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val subject: Subject,
    val solved: Boolean
)
