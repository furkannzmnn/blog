package com.example.blog.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val fullName: String=  "",

    val age: Byte,

    val imageUrl: String?,


    @OneToMany(mappedBy = "author" , fetch = FetchType.LAZY)
    val socialMedia: Set<SocialMedia>? = HashSet(),

    @Enumerated(EnumType.STRING)
    val sex: Sex?,

    @JsonIgnore
    @OneToMany(mappedBy = "author" , fetch = FetchType.LAZY )
    val blog: Set<Blog> = HashSet(),


    ) {

        constructor(fullName: String, age: Byte, imageUrl: String?, socialMedia: Set<SocialMedia>, sex: Sex?)
                :this(1,fullName,age,imageUrl,socialMedia,sex,HashSet()) {}

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Author

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , fullName = $fullName , age = $age , imageUrl = $imageUrl , sex = $sex )"
    }

}
