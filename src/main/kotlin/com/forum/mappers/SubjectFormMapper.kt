package com.forum.mappers

import com.forum.dtos.SubjectFormDTO
import com.forum.models.Subject
import com.forum.services.CourseService
import com.forum.services.UserClientService
import org.springframework.stereotype.Component

@Component
class SubjectFormMapper(
    private val courseService: CourseService,
    private val userClientService: UserClientService
): Mapper<SubjectFormDTO, Subject> {

    override fun map(subject: SubjectFormDTO): Subject {
        return Subject(
            title = subject.title,
            message = subject.message,
            course = courseService.getById(subject.idCourse),
            user = userClientService.getById(subject.idUser)
        )
    }
}