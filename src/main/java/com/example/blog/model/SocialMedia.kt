package com.example.blog.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "social_media")
data class SocialMedia(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = 0    ,

    val link: String? ,



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY , cascade = [CascadeType.ALL] )
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    var author: Author?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SocialMedia

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , link = $link )"
    }
}
