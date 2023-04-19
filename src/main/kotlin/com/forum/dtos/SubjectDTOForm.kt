package com.forum.dtos

data class SubjectDTOForm(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idUser: Long
)