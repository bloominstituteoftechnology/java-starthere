package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public interface BookService
{
    List<Book> findAll(Pageable pageable);

    Book save(Book book);

    Book findBookById(long id);

    void delete(long id);

    Book update(Book book, long id);

}


//
//
//@RestController
//@RequestMapping("/books")
//public class BookController
//{
//
//    @Autowired
//    private BookService bookService;
//
//    @ApiOperation(value = "returns all Books")
//
//    @ApiImplicitParams({@ApiImplicitParam(name = "page",
//                                          dataType = "integer",
//                                          paramType = "query",
//                                          value = "Results page you want to retrieve (0..N)"), @ApiImplicitParam(name = "size",
//                                                                                                                 dataType = "integer", value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
//
//    //create a list of books
//    @GetMapping(value = "/books/books",
//                produces = {"application/json"})
//
//    public ResponseEntity<?> listAllBooks(
//            @PageableDefault(page = 0,
//                             size = 5)
//                    PageableDefault pageable)
//    {
//        List<Book> myBooks = new ArrayList<>();
//        bookService.findAll(Pageable.unpaged()).iterator().forEachRemaining(myBooks::add);
//        return new ResponseEntity<>(myBooks, null, HttpStatus.OK);