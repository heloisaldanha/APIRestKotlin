package com.forum.service

import com.forum.dtos.SubjectFormDTO
import com.forum.exceptions.NotFoundException
import com.forum.mappers.SubjectFormMapper
import com.forum.mappers.SubjectViewMapper
import com.forum.model.*
import com.forum.models.Subject
import com.forum.respositories.SubjectRepository
import com.forum.services.SubjectService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class SubjectServiceTest {
    val subjects = PageImpl(listOf(SubjectTest.build()))
    val page : Pageable = mockk()

    val subjectRepository: SubjectRepository = mockk {
        every { findByCourseName(any(), any()) } returns subjects
        every { findAll(page) } returns subjects
    }
    val subjectViewMapper: SubjectViewMapper = mockk {
        every { map(any()) } returns SubjectViewTest.build()
    }
    val subjectFormMapper: SubjectFormMapper = mockk {
        every { map(any()) } returns  SubjectFormTest.build()
    }

    val subjectService = SubjectService(
            subjectRepository, subjectViewMapper, subjectFormMapper
    )

    @Test
    fun `should list subjects by course name`() {
        every { subjectViewMapper.map(any()) } returns SubjectViewTest.build()
        subjectService.getListSubject("Kotlin", page)

        verify(exactly = 1) { subjectRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { subjectViewMapper.map(any()) }
        verify(exactly = 0) { subjectRepository.findAll(page) }
    }

    @Test
    fun `should list all subjects when the course name is null`() {
        subjectService.getListSubject(null, page)

        verify(exactly = 0) { subjectRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { subjectViewMapper.map(any()) }
        verify(exactly = 1) { subjectRepository.findAll(page) }
    }

    @Test
    fun `should not shows a subject when subject id not found`() {
        every { subjectRepository.findById(any()) } returns Optional.empty()

        val actual = assertThrows<NotFoundException> {
            subjectService.getById(1)
        }

        assertThat(actual.message).isEqualTo("ID não encontrado.")
    }

    @Test
    fun `should create a subject and return subject view`() {

        val form = SubjectFormDTO(
            title = "Kotlin",
            message = "Kotlin",
            idCourse = 1L,
            idUser = 1L
        )

        val expectedSubject = Subject(
            title = form.title,
            message = form.message,
            course = CourseTest.build(),
            user = UserClientTest.build()
        )

        every { subjectFormMapper.map(form) } returns expectedSubject
        every { subjectRepository.save(expectedSubject) } returns expectedSubject

        val expectedView = SubjectViewTest.build()
        every { subjectViewMapper.map(expectedSubject) } returns expectedView

        val actualView = subjectService.create(form)
        assertEquals(expectedView, actualView)

        verify(exactly = 1) { subjectFormMapper.map(form) }
        verify(exactly = 1) { subjectRepository.save(expectedSubject) }
        verify(exactly = 1) { subjectViewMapper.map(expectedSubject) }
    }
}