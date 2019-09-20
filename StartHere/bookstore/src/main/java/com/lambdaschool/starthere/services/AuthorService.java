package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll();
    Author save(Author author);
}
