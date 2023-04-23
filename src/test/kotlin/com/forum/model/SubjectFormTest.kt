package com.forum.model

import com.forum.enums.Status
import com.forum.models.Subject
import java.time.LocalDateTime

object SubjectFormTest {

    fun build() = Subject(
        title = "API REST com Kotlin",
        message = "API REST com Kotlin",
        createdAt = LocalDateTime.now(),
        course = CourseTest.build(),
        user = UserClientTest.build(),
        status = Status.NOT_ANSWERED
    )
}