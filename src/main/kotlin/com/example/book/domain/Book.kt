package com.example.book.domain
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "books")
class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long? = null,

        @NotBlank
        @Size(min = 1, max = 255)
        @Column(name = "name")
        var name: String
)