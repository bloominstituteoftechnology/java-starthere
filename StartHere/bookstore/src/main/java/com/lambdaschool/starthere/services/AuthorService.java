package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll(Pageable pageable);

    Author save(Author author);

    Author findByFname(String fname);

    Author findByLname(String lname);

    Author findAuthorById(long id);

    void delete(long id);

    Author update(Author author, long id);
    //Author update(Author author);
}
