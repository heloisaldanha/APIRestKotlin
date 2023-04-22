package com.forum.model

import com.forum.dtos.SubjectViewDTO
import com.forum.enums.Status
import java.time.LocalDateTime

object SubjectViewTest {

    fun build() = SubjectViewDTO(
        id = 1,
        title = "Desenvolvendo API com Kotlin",
        message = "Do básico ao deploy",
        status = Status.NOT_ANSWERED,
        createdAt = LocalDateTime.now()
    )

}