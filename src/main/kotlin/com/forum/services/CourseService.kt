package com.forum.services

import com.forum.models.Course
import com.forum.respositories.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {

    fun getById(id: Long): Course {
        return repository.getReferenceById(id)
    }

}