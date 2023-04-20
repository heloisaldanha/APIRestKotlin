package com.forum.dtos

import com.forum.enums.Status
import java.time.LocalDateTime

data class SubjectViewDTO(
    val id: Long? = null,
    val title: String,
    val message: String,
    val status: Status,
    val createdAt: LocalDateTime
)
