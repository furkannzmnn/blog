package com.example.blog.model

import org.hibernate.Hibernate
import org.hibernate.annotations.GeneratorType
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.repository.EntityGraph
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
    val createdTime: LocalDateTime?,

    @LastModifiedBy
    val lastUpdateTime: LocalDateTime?,

    @Column(length = 4000 , nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY , cascade = [CascadeType.ALL])
    @JoinColumn(name = "author_id" ,referencedColumnName = "author")
    val author: Author?



) {
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
