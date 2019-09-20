package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>

{
}
