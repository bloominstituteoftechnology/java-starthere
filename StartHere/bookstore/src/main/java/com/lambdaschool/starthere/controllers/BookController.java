package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController
{
    @Autowired
    private BookService bookService;
            //create a list of books
    @GetMapping(value = "/books/books",
                produces ={"application/json"})

    public ResponseEntity<?> listAllProducts()
    {
        List<Book> myBooks = new ArrayList<>();
        bookService.findAll().iterator().forEachRemaining(myBooks::add);
        return new ResponseEntity<>(myBooks, null, HttpStatus.OK);
    }
}
