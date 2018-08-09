package com.boot.controller;

import com.boot.model.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStub {

    private static Map<Long, Book> books = new HashMap<Long, Book>();
    private static Long idIndex = 2L;

    //populate initial books
    static {
        Book a = new Book(1L, "El niño del holocausto", "Jack Kuper", "insert here description",  1994);
        books.put(1L, a);

        Book b = new Book(2L, "20.000 Leguas de viaje submarino", "Jules Verne", "insert here description",  1990);
        books.put(2L, b);
    }

    public static List<Book> list() {
        return new ArrayList<Book>(books.values());
    }

    public static Book create(Book book) {
        idIndex += idIndex;
        book.setId(idIndex);
        books.put(idIndex, book);
        return book;
    }

    public static Book get(Long id) {
        return books.get(id);
    }

    public static Book update(Long id, Book book) {
        books.put(id, book);
        return book;
    }

    public static Book delete(Long id) {
        return books.remove(id);
    }


}
