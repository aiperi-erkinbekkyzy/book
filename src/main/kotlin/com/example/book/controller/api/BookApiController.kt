package com.example.book.controller.api

import com.example.book.domain.BookEntity
import com.example.book.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PostMapping


@RestController
@RequestMapping("/api/books")
class BookApiController(private val bookService: BookService) {

    @GetMapping
    fun findAll(): List<BookEntity> {
        return bookService.getAll()
    }

    @PostMapping
    fun create(@Valid @RequestBody product: BookEntity): BookEntity {
        return bookService.createOrUpdate(product)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): BookEntity {
        return bookService.getById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody book: BookEntity): BookEntity {
        return bookService.createOrUpdate(book)
    }
}