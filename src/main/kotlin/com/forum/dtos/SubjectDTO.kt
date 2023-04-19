package com.forum.dtos

data class SubjectDTO(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idUser: Long
)