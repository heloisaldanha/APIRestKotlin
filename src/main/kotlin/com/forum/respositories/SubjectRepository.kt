package com.forum.respositories

import com.forum.dtos.SubjectForCategoryDTO
import com.forum.models.Subject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SubjectRepository: JpaRepository<Subject, Long> {

    fun findByCourseName(courseName: String, page: Pageable): Page<Subject>

    @Query(
        "SELECT new com.forum.dtos.SubjectForCategoryDTO(course.category, count(s)) FROM Subject s JOIN s.course course GROUP BY course.category"
    )
    fun getReport(): List<SubjectForCategoryDTO>
}