package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value ="authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authres;

    @Override
    public List<Author> findAll(Pageable pageable)
    {
        List<Author> theAuthors = new ArrayList();
        authres.findAll().iterator().forEachRemaining(theAuthors::add);
        return theAuthors;
    }


    @Transactional
    @Override
    public Author save(Author author)
    {
        Author newAuthor = new Author();
        newAuthor.setFname(author.getFname());
        newAuthor.setLname(author.getLname());
        return authres.save(author);

    }
}
