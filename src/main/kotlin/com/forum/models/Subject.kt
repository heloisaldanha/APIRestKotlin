package com.forum.models

import com.forum.enums.Status
import java.time.LocalDateTime

data class Subject(
    var id: Long? = null,
    val title : String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val user: User,
    val status: Status = Status.NOT_ANSWERED,
    val reply: List<Reply> = ArrayList()
)
