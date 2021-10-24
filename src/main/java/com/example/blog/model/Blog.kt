package com.example.blog.model

import com.fasterxml.jackson.annotation.JacksonInject
import org.hibernate.Hibernate
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "blog")
data class Blog(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id : UUID?,


    @CreatedDate
    val createdTime: LocalDateTime? = LocalDateTime.now(),

    @LastModifiedBy
    val lastUpdateTime: LocalDateTime? = LocalDateTime.now(),

    @Column(length = 10000 , nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY , cascade = [CascadeType.ALL])
    @JoinColumn(name = "authors_id")
    val author: Author? = null




) {
    constructor(content: String , author: Author?): this(null, null, null,content,author){}



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Blog

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , createdTime = $createdTime , lastUpdateTime = $lastUpdateTime , content = $content )"
    }
}
