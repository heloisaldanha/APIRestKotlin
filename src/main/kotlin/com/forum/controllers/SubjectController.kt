package com.forum.controllers

import com.forum.dtos.SubjectFormDTO
import com.forum.dtos.SubjectViewDTO
import com.forum.dtos.UpdateSubjectFormDTO
import com.forum.services.SubjectService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/topicos")
class SubjectController(private val service: SubjectService) {

    @GetMapping
    fun getListSubjects(): List<SubjectViewDTO> {
        return service.getListSubject()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): SubjectViewDTO {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid subjectFormDto: SubjectFormDTO) {
        service.create(subjectFormDto)
    }

    @PutMapping
    fun update(@RequestBody @Valid updateSubjectFormDTO: UpdateSubjectFormDTO) {
        service.update(updateSubjectFormDTO)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}