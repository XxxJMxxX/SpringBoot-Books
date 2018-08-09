package com.boot.controller;

import com.boot.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class BookController
{

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks()
    {
        return BookStub.list();
    }

    @RequestMapping(value = "books", method = RequestMethod.POST, consumes = {"application/json"})
    public Book createBook(@RequestBody Book book)
    {
        return BookStub.create(book);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id)
    {
        return BookStub.get(id);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable Long id, @RequestBody Book book)
    {
        return BookStub.update(id, book);
    }

    @RequestMapping(value = "books", method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable Long id)
    {
        return BookStub.delete(id);
    }

}
