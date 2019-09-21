package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController
{

@Autowired
private BookService bookService;

    @ApiOperation(value ="returns all Books", responseContainer = "Book List")

    @ApiImplicitParams({
                               @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                                                 value = "Results page you want to retrieve (0..N)"),
                               @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                                                 value = "Number of records per page."),
                               @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                                 value = "Sorting criteria in the format: property(,asc|desc). " +
                                                         "Default sort order is ascending. " +
                                                         "Multiple sort criteria are supported.")})

    //create a list of books
    @GetMapping(value = "/books/books",
                produces ={"application/json"})


public ResponseEntity<?> listAllBooks(
            @PageableDefault(page = 0,
                             size = 5)
                    Pageable pageable,
            //documentation for a pathVariable
            //customer swagger documentation for
            //this endpoint
    @ApiParam(value = "Book Id", required = true, example ="1")
    @PathVariable
    Long bookid)
    {

        List<Book> myBooks = new ArrayList<>();
        bookService.findAll(pageable).iterator().forEachRemaining(myBooks::add);
        return new ResponseEntity<>(myBooks, null, HttpStatus.OK);
    }
}
