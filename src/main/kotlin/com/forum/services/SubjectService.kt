package com.forum.services

import com.forum.models.Course
import com.forum.models.Subject
import com.forum.models.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SubjectService(private var subjects: List<Subject>) {

    init {
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

        val subject2 = Subject(
            id = 2,
            title = "Desenvolvendo API com Kotlin 2",
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

        val subject3 = Subject(
            id = 3,
            title = "Desenvolvendo API com Kotlin 3",
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

        subjects = listOf(subject, subject2, subject3)
    }
    fun getListSubject(): List<Subject> {
        return subjects
    }

    fun getById(id: Long): Subject {
        val subjectById = subjects.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return subjectById
    }
}