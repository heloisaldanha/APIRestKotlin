package com.forum.mappers

import com.forum.dtos.SubjectViewDTO
import com.forum.models.Subject
import org.springframework.stereotype.Component


@Component
class SubjectViewMapper(): Mapper<Subject, SubjectViewDTO> {

    override fun map(subject: Subject): SubjectViewDTO {
        return SubjectViewDTO(
            id = subject.id,
            title = subject.title,
            message = subject.message,
            status = subject.status,
            createdAt = subject.createdAt
        )
    }
}