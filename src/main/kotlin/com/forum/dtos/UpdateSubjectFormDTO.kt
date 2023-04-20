package com.forum.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateSubjectFormDTO(

    @field:NotNull
    val id: Long,

    @field:NotEmpty
    @field:Size(min = 5, max = 200)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 5)
    val message: String
)
