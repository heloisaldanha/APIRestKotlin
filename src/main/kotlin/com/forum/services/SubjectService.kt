package com.forum.services

import com.forum.dtos.SubjectFormDTO
import com.forum.dtos.SubjectViewDTO
import com.forum.dtos.UpdateSubjectFormDTO
import com.forum.exceptions.NotFoundException
import com.forum.mappers.SubjectFormMapper
import com.forum.mappers.SubjectViewMapper
import com.forum.respositories.SubjectRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SubjectService(
    private var repository: SubjectRepository,
    private val subjectViewMapper: SubjectViewMapper,
    private val subjectFormMapper: SubjectFormMapper
) {

    fun getListSubject(courseName: String?, page: Pageable): Page<SubjectViewDTO> {
        val subjects = if (courseName.isNullOrEmpty()) {
            repository.findAll(page)
        } else {
            repository.findByCourseName(courseName, page)
        }
        return subjects.map { subject -> subjectViewMapper.map(subject)
        }
    }

    fun getById(id: Long): SubjectViewDTO {
        val subjectById = repository.findById(id).orElseThrow { NotFoundException("ID não encontrado.") }

        return subjectViewMapper.map(subjectById)
    }

    fun create(form: SubjectFormDTO): SubjectViewDTO {
        val subject = subjectFormMapper.map(form)
        repository.save(subject)
        return subjectViewMapper.map(subject)
    }

    fun update(updateSubjectFormDTO: UpdateSubjectFormDTO): SubjectViewDTO {
        val subject = repository.findById(updateSubjectFormDTO.id).orElseThrow { NotFoundException("ID não encontrado.") }
        subject.title = updateSubjectFormDTO.title
        subject.message = updateSubjectFormDTO.message
        return subjectViewMapper.map(subject)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}