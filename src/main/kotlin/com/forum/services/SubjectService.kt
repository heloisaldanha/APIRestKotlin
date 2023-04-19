package com.forum.services

import com.forum.models.Subject
import org.springframework.stereotype.Service

@Service
class SubjectService(private var subjects: List<Subject> = mutableListOf()) {

    fun getListSubject(): List<Subject> {
        return subjects
    }

    fun getById(id: Long): Subject {
        val subjectById = subjects.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return subjectById
    }

    fun create(subject: Subject) {
        subjects.plus(subject)
    }
}