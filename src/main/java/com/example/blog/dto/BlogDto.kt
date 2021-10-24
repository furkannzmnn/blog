package com.example.blog.dto

import com.example.blog.model.Author
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

data class BlogDto(


    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy")
    val createdTime: LocalDateTime?,

    val lastUpdateTime: LocalDateTime?,

    val content: String,

    val author: Author
)
