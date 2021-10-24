package com.example.blog.dto

import com.example.blog.model.Blog
import com.example.blog.model.Sex
import com.example.blog.model.SocialMedia
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.OneToMany

data class AuthorDto(
    val fullName: String,

    val age: Byte,

    val imageUrl: String?,

    val socialMedia: Set<SocialMedia>,

    val sex: Sex?,

    val blog: Set<Blog>
)
