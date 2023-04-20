package com.forum.respositories

import com.forum.models.Subject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository: JpaRepository<Subject, Long> {

    fun findByCourseName(courseName: String, page: Pageable): Page<Subject>
}