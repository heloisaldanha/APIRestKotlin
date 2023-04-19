package com.forum.services

import com.forum.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )

        courses = listOf(course)
    }

    fun getById(id: Long): Course {
        val courseById = courses.stream().filter { course ->
            course.id == id
        }.findFirst().get()

        return courseById
    }

}