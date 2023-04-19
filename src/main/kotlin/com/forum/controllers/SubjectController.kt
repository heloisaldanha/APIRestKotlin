package com.forum.controllers

import com.forum.dtos.SubjectDTO
import com.forum.models.Subject
import com.forum.services.SubjectService
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
    fun getListSubjects(): List<Subject> {
        return service.getListSubject()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Subject {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody subjectDto: SubjectDTO) {
        service.create(subjectDto)
    }

}