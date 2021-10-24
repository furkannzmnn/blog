package com.example.blog.dto.request

import com.example.blog.model.Sex
import com.example.blog.model.SocialMedia
import org.hibernate.validator.constraints.Length
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AuthorSaveRequest(

    @NotBlank(message = "full name is not be empty")
    val fullName: String,

    @field:Length(min = 0 , max = 100 , message = "valid length -> 0< max < 100")
    val age: Byte,

    val imageUrl: String?,

    val socialMedia: Set<SocialMedia>,

    @field:NotNull
    val sex: Sex?,

    )
