package com.forum.respositories

import com.forum.models.Subject
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository: JpaRepository<Subject, Long> {

    fun findByCourseName(courseName: String): List<Subject>
}