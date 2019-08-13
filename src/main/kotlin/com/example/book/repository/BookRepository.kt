package com.example.book.repository

import com.example.book.domain.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository : JpaRepository<BookEntity, Long>