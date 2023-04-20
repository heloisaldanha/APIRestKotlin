package com.forum.controllers

import com.forum.dtos.SubjectFormDTO
import com.forum.dtos.SubjectViewDTO
import com.forum.dtos.UpdateSubjectFormDTO
import com.forum.services.SubjectService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*


@RestController
@RequestMapping("/topicos")
class SubjectController(private val service: SubjectService) {

    @GetMapping
    fun getListSubjects(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = [ "createdAt" ], direction = Sort.Direction.DESC ) page: Pageable
    ): Page<SubjectViewDTO> = service.getListSubject(courseName, page)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): SubjectViewDTO = service.getById(id)


    @PostMapping
    @Transactional
    fun create(
        @RequestBody @Valid subjectFormDto: SubjectFormDTO,
        uriBuilder: UriComponentsBuilder  // UriComponentsBuild vai chamar a uri do servidor
    ):ResponseEntity<SubjectViewDTO> {
        val subjectView = service.create(subjectFormDto)
        val uri = uriBuilder.path("/topicos/${subjectView.id}").build().toUri()
        return ResponseEntity.created(uri).body(subjectView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid updateSubjectFormDTO: UpdateSubjectFormDTO): ResponseEntity<SubjectViewDTO> {
        val subjectView = service.update(updateSubjectFormDTO)
        return ResponseEntity.ok(subjectView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) = service.delete(id)

}