package com.forum.controllers

import com.forum.enums.Status
import com.forum.models.Course
import com.forum.models.Subject
import com.forum.models.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*


@RestController
@RequestMapping("/topicos")
class SubjectController {

    @GetMapping
    fun getListSubjects(): List<Subject> {
        val subject = Subject(
            id = 1,
            title = "Desenvolvendo API com Kotlin",
            message = "Do básico ao deploy",
            createdAt = LocalDateTime.now(),
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Linguagem de programação"
            ),
            author = User(
                id = 1,
                name = "Heloísa Saldanha",
                email = "heloisa@saldanha.com"
            )
        )

        return listOf(subject, subject, subject, subject)
    }

}