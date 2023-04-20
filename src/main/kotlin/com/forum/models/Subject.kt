package com.forum.models

import com.forum.enums.Status
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Subject(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title : String,
    var message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val user: UserClient,

    @Enumerated(value = EnumType.STRING)
    val status: Status = Status.NOT_ANSWERED,

    @OneToMany(mappedBy = "subject")
    val reply: List<Reply> = ArrayList()
)
