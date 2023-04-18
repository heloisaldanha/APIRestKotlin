package com.forum.services

import com.forum.models.Course
import com.forum.models.Subject
import com.forum.models.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SubjectService {
    fun getListSubject(): List<Subject> {
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