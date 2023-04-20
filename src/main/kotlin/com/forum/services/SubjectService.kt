package com.forum.services

import com.forum.dtos.SubjectFormDTO
import com.forum.dtos.SubjectViewDTO
import com.forum.dtos.UpdateSubjectFormDTO
import com.forum.mappers.SubjectFormMapper
import com.forum.mappers.SubjectViewMapper
import com.forum.models.Subject
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SubjectService(
    private var subjects: List<Subject> = mutableListOf(),
    private val subjectViewMapper: SubjectViewMapper,
    private val subjectFormMapper: SubjectFormMapper
) {

    fun getListSubject(): List<SubjectViewDTO> {
        return subjects.stream().map { subject -> subjectViewMapper.map(subject)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): SubjectViewDTO {
        val subjectById = subjects.stream().filter { subject ->
            subject.id == id
        }.findFirst().get()

        return subjectViewMapper.map(subjectById)
    }

    fun create(form: SubjectFormDTO): SubjectViewDTO {
        val subject = subjectFormMapper.map(form)
        subject.id = subjects.size.toLong() + 1
        subjects = subjects.plus(subject)
        return subjectViewMapper.map(subject)
    }

    fun update(updateSubjectFormDTO: UpdateSubjectFormDTO): SubjectViewDTO {
        val subject = subjects.stream().filter {subject ->
            subject.id == updateSubjectFormDTO.id
        }.findFirst().get()

        val subjectViewUpdated = Subject(
            id = updateSubjectFormDTO.id,
            title = updateSubjectFormDTO.title,
            message = updateSubjectFormDTO.message,
            user = subject.user,
            course = subject.course,
            reply = subject.reply,
            status = subject.status,
            createdAt = subject.createdAt
        )

        subjects = subjects.minus(subject).plus(subjectViewUpdated)
        return subjectViewMapper.map(subjectViewUpdated)
    }

    fun delete(id: Long) {
        val subject = subjects.stream().filter {subject ->
            subject.id == id
        }.findFirst().get()

        subjects = subjects.minus(subject)
    }
}