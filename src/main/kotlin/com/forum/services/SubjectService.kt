package com.forum.services

import com.forum.dtos.SubjectDTOForm
import com.forum.dtos.SubjectDTOView
import com.forum.models.Subject
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SubjectService(
    private var subjects: List<Subject> = mutableListOf(),
    private var courseService: CourseService,
    private var userService: UserService
) {

    fun getListSubject(): List<SubjectDTOView> {
        return subjects.stream().map { subject -> SubjectDTOView(
            id = subject.id,
            title = subject.title,
            message = subject.message,
            status = subject.status,
            createdAt = subject.createdAt
            )
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): SubjectDTOView {
        val subjectById = subjects.stream().filter { subject ->
            subject.id == id
        }.findFirst().get()

        return SubjectDTOView(
            id = subjectById.id,
            title = subjectById.title,
            message = subjectById.message,
            status = subjectById.status,
            createdAt = subjectById.createdAt
        )
    }

    fun create(subjectDto: SubjectDTOForm) {
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