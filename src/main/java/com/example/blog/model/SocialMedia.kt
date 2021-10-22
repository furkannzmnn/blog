package com.example.blog.model

import javax.persistence.*

@Entity
@Table(name = "social_media")
data class SocialMedia(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val link: String? ,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: Author ?


)
