package com.forum.services

import com.forum.dtos.SubjectDTOForm
import com.forum.dtos.SubjectDTOView
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

    fun getListSubject(): List<SubjectDTOView> {
        return subjects.stream().map { subject -> subjectViewMapper.map(subject)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): SubjectDTOView {
        val subjectById = subjects.stream().filter { subject ->
            subject.id == id
        }.findFirst().get()

        return subjectViewMapper.map(subjectById)
    }

    fun create(form: SubjectDTOForm) {
        val subject = subjectFormMapper.map(form)
        subject.id = subjects.size.toLong() + 1
        subjects = subjects.plus(subject)
    }
}