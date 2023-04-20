package com.forum.controllers

import com.forum.dtos.SubjectDTOForm
import com.forum.dtos.SubjectDTOView
import com.forum.services.SubjectService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/topicos")
class SubjectController(private val service: SubjectService) {

    @GetMapping
    fun getListSubjects(): List<SubjectDTOView> {
        return service.getListSubject()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): SubjectDTOView {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid subjectDto: SubjectDTOForm) {
        service.create(subjectDto)
    }

}