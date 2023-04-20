package com.forum.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class SubjectFormDTO(

    @field:NotEmpty
    @field:Size(min = 5, max = 200)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 5)
    val message: String,

    @field:NotNull
    val idCourse: Long,

    @field:NotNull
    val idUser: Long
)