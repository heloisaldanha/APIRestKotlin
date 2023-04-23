package com.forum.model

import com.forum.models.Subject

object SubjectTest {

    fun build() = Subject(
        id = 1,
        title = "API REST com Kotlin",
        message = "API REST com Kotlin",
        course = CourseTest.build(),
        user = UserClientTest.build()
    )
}