package com.forum.models

import com.forum.enums.Status
import java.time.LocalDateTime

data class Subject(
    val id: Long? = null,
    val title : String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: Status = Status.NOT_ANSWERED,
    val reply: List<Reply> = ArrayList()
)
