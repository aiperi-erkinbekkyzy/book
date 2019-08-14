package com.example.book.service

import com.example.book.domain.BookEntity
import com.example.book.repository.BookRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
class BookService(private val repository: BookRepository) {

    fun getAll(): List<BookEntity> {
        return repository.findAll()
    }

    fun getById(id: Long): BookEntity {
        val book = repository.findById(id)

        return if (book.isPresent) {
            book.get()
        } else {
            // как правильно выбросить ошибку если нет записи?
            // как работать с optional полями?
            throw NotFoundException("No record exist for given id")
        }
    }

    fun create(entity: BookEntity): BookEntity {
        return repository.save(entity)
    }

    fun update(entity: BookEntity): BookEntity {
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
            throw NotFoundException("No record exist for given id")
        }
    }
}