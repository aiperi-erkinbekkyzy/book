package com.example.book.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "books")
class BookEntity(
        @Id
        @GeneratedValue
        @Column(name = "id")
        var id: Long,

        @NotBlank
        @Size(min = 1, max = 255)
        @Column(name = "name")
        var name: String,

        @Column(name = "amount")
        var amount: Int,

        @Column(name = "price")
        var price: Double,

        @Size(min = 1, max = 255)
        @Column(name = "description")
        var description: String,

        @Size(min = 1, max = 255)
        @Column(name = "category")
        var category: String
)