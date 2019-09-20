package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
