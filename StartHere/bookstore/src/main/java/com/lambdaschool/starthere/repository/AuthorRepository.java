package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>
{

    Author update(Author newAuthor);

    Author findByName(String fname, String lname);

    Author findByFname(String fname);

    Author findByLname(String lname);
}
