package com.forum.services

import com.forum.dtos.SubjectFormDTO
import com.forum.dtos.SubjectViewDTO
import com.forum.dtos.UpdateSubjectFormDTO
import com.forum.exceptions.NotFoundException
import com.forum.mappers.SubjectFormMapper
import com.forum.mappers.SubjectViewMapper
import com.forum.respositories.SubjectRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SubjectService(
    private var repository: SubjectRepository,
    private val subjectViewMapper: SubjectViewMapper,
    private val subjectFormMapper: SubjectFormMapper
) {

    fun getListSubject(): List<SubjectViewDTO> {
        return repository.findAll().stream().map { subject -> subjectViewMapper.map(subject)
        }.collect(Collectors.toList())
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