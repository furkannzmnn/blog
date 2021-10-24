package com.example.blog.dto.request

import com.example.blog.model.Author
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class BlogSaveRequest(

    @field:NotBlank(message = "blog content is not be empty")
    @field:Length(message = "valid length -> 1500< max < 100000" , min = 12 , max = 100000)
    val content: String,

    @field:NotNull(message = "author is not be empty")
    val author: Author
)