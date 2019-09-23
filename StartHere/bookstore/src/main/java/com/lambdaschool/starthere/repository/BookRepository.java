package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;


//To do paging and sorting, changed CrudRepository to PagingAndSortingRepository

public interface BookRepository extends PagingAndSortingRepository<Book, Long>

{

}