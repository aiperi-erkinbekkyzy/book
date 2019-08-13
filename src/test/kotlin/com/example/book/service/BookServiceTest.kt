package com.example.book.service

import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.junit.runner.RunWith


@RunWith(SpringRunner::class)
@SpringBootTest
class BookServiceTest(private val bookService: BookService) {

    @Test
    fun whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        val books = bookService.getAll()

        Assert.assertEquals(books.size, 3)
    }
}
