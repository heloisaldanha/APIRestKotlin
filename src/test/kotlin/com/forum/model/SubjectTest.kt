package com.forum.model

import com.forum.models.Subject

object SubjectTest {

    fun build() = Subject(
        id = 1,
        title = "Desenvolvendo API com Kotlin",
        message = "Do básico ao deploy",
        course = CourseTest.build(),
        user = UserClientTest.build()
    )
}