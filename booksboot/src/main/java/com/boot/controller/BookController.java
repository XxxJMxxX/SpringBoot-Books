package com.boot.controller;

import com.boot.model.Book;
import com.boot.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class BookController
{

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "books", method = RequestMethod.POST, consumes = {"application/json"})
    public Book createBook(@RequestBody Book book)
    {
        return bookRepository.saveAndFlush(book);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id)
    {
        return bookRepository.findOne(id);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable Long id, @RequestBody Book book)
    {
        Book existingBook = bookRepository.findOne(id);
        BeanUtils.copyProperties(book, existingBook);// copy the new data of the book to the existing one
        return bookRepository.saveAndFlush(existingBook);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable Long id)
    {
        Book existingBook = bookRepository.findOne(id);
        bookRepository.delete(existingBook);
        return existingBook;
    }

}
