package com.forum.services

import com.forum.dtos.SubjectDTO
import com.forum.models.Subject
import org.springframework.stereotype.Service

@Service
class SubjectService(
    private var subjects: List<Subject> = mutableListOf(),
    private var courseService: CourseService,
    private var userService: UserService
) {

    fun getListSubject(): List<Subject> {
        return subjects
    }

    fun getById(id: Long): Subject {
        val subjectById = subjects.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return subjectById
    }

    fun create(subjectDto: SubjectDTO) {
        subjects = subjects.plus(Subject(
            id = subjects.size.toLong() + 1,
            title = subjectDto.title,
            message = subjectDto.message,
            course = courseService.getById(subjectDto.idCourse),
            user = userService.getById(subjectDto.idUser)
        )

        )
    }
}