package com.example.book.service

import com.example.book.domain.BookEntity
import com.example.book.repository.BookRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service
import java.util.ArrayList


@Service
class BookService(private val repository: BookRepository) {

    fun getAll(): List<BookEntity> {
        val books = repository.findAll()

        return if (books.size > 0) {
            books
        } else {
            ArrayList()
        }
    }

    @Throws(NotFoundException::class)
    fun getById(id: Long): BookEntity {
        val book = repository.findById(id)

        return if (book.isPresent) {
            book.get()
        } else {
            throw NotFoundException("No record exist for given id")
        }
    }

    @Throws(NotFoundException::class)
    fun createOrUpdate(entity: BookEntity): BookEntity {
        val book = repository.findById(entity.id)

        if (book.isPresent) {
            var newEntity = book.get()
            newEntity.name = entity.name
            newEntity.amount = entity.amount
            newEntity.price = entity.price
            newEntity.description = entity.description
            newEntity.category = entity.category
            // как можно сократить? TS => newEntity = {...entity}; object.assign();

            newEntity = repository.save(newEntity)

            return newEntity
        } else {
            return repository.save(entity)
        }
    }
}