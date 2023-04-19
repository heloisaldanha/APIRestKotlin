package com.forum.mappers

import com.forum.dtos.SubjectDTOForm
import com.forum.models.Subject
import com.forum.services.CourseService
import com.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class SubjectFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
): Mapper<SubjectDTOForm, Subject> {

    override fun map(subject: SubjectDTOForm): Subject {
        return Subject(
            title = subject.title,
            message = subject.message,
            course = courseService.getById(subject.idCourse),
            user = userService.getById(subject.idUser)
        )
    }
}