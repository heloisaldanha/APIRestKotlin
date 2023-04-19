package com.forum.mappers

import com.forum.dtos.SubjectDTOView
import com.forum.models.Subject
import org.springframework.stereotype.Component


@Component
class SubjectViewMapper(): Mapper<Subject, SubjectDTOView> {

    override fun map(subject: Subject): SubjectDTOView {
        return SubjectDTOView(
            id = subject.id,
            title = subject.title,
            message = subject.message,
            status = subject.status,
            createdAt = subject.createdAt
        )
    }
}