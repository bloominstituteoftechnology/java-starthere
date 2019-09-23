package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.services.AuthorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
//To do paging and sorting, changed CrudRepository to PagingAndSortingRepository

public class AuthorController
{
    @Autowired
    private AuthorService authorService;

            @ApiOperation(value = "returns all Author Names", responseContainer = "Book List")
            @ApiImplicitParams({

                                   @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                                                     value = "Results page you want to retrieve (0..N)"),
                                   @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                                                     value = "Number of records per page."),
                                   @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                                     value = "Sorting criteria in the format: property(,asc|desc). " +
                                                             "Default sort order is ascending. " +
                                                             "Multiple sort criteria are supported.")})

            //create a list of authors
            @GetMapping(value = "/allauthors",
                        produces = {"application/json"})

            public ResponseEntity<?> listAllAuthors(
                    @PageableDefault(page = 0,
                                     size = 5)
                            Pageable pageable,
                    //documentation for a pathVariable
                    //customer swagger documentation for
                    //this endpoint
                    @ApiParam(value = "Author", required = true, example ="1")
                    @PathVariable
                        Long authorid)
            {
                List<Author> myAuthors = new ArrayList<>();
                authorService.findAll(pageable).iterator().forEachRemaining(myAuthors::add);
                return new ResponseEntity<>(myAuthors, null, HttpStatus.OK);
            }
            
            //find authors by id
            @GetMapping(value = "/authors/{authorId}",
                        produces = {"application/json"})
            public ResponseEntity<?> getAuthor(
                    @PathVariable
                        Long authorId)
            {
                Author a = authorService.findAuthorById((authorId));
                return new ResponseEntity<>(a, HttpStatus.OK);
            }
            
            //find authors by name
            @GetMapping(value ="/authorname/{authorName}",
                        produces = {"application/json"})
            public ResponseEntity<?> findAuthorByName(
                    @PathVariable
                        String  authorName)

            {
                List<Author> theAuthors = new ArrayList<>();
                authorService.findByFname(authorName);
                authorService.findByLname(authorName);
                return new ResponseEntity<>(theAuthors, HttpStatus.OK);
            }

            //delete Authors by id
            @DeleteMapping("/author/{id}")
            public ResponseEntity<?> deleteQuoteById(
                    @PathVariable
                        long id)
            {
                authorService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            //update authors
            @PutMapping(value = "/author/{authorid")
            public ResponseEntity<?>updateAuthor(
                    @RequestBody
                        Author updateAuthor,
                    @PathVariable
                        long authorid)
            {
                authorService.update(updateAuthor, authorid);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            //saved authors
            @PostMapping(value= "/author")
            public ResponseEntity<?> addNewAuthor(@Valid @RequestBody Author savedAuthor) throws URISyntaxException
            {
                savedAuthor = authorService.save(savedAuthor);

                //set the location header for the newly created resource
                HttpHeaders responseHeaders = new HttpHeaders();
                URI savedAuthorURI = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{authorid}")
                        .buildAndExpand()
                        .toUri();

                responseHeaders.setLocation(savedAuthorURI);

                return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
            }
        }
