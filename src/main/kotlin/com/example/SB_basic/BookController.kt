package com.example.SB_basic

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {

    private val books= mutableListOf<Book>()


    @GetMapping
    fun getBooks():List<Book>{
        return books
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable("id") id:Long):Book?{
    return books.find { it.id==id }
    }


    @PostMapping
    fun createBook(@RequestBody book: Book):Book{
         books.add(book)
        return book
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable("id") id:Long,@RequestBody newbook: Book){
        val book=books.find { it.id==id }
        book?.let{
            it.id=newbook.id
            it.name=newbook.name
            it.author=newbook.author
        }
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable("id") id:Long){
        books.removeIf { it.id==id }
    }

}