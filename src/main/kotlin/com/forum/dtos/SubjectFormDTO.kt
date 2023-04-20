package com.forum.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class SubjectFormDTO(

    @field:NotEmpty(message = "Título não pode ser vazio")
    @field:Size(min = 5, max = 200, message = "Título deve ter entre 5 e 200 caracteres")
    val title: String,

    @field:NotEmpty(message = "Mensagem não pode ser vazia")
    @field:Size(min = 5, message = "Mensagem com no mínimo 5 caracteres")
    val message: String,

    @field:NotNull(message = "Id do curso não pode ser nulo")
    val idCourse: Long,

    @field:NotNull
    val idUser: Long
)