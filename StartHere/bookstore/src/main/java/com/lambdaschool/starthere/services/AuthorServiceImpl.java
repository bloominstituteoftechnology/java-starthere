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

    @Override
    public Author findAuthorById(long id) throws EntityNotFoundException
    {
        {
        return authres.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        }
    }


    @Override
    public Author update(Author author, long id)
    {

        Author newAuthor = authres.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (author.getFname() !=null)
        {
            newAuthor.setFname(author.getFname());
        }
        if (author.getLname() !=null)
        {
            newAuthor.setLname((author.getLname()));
        }
        return authres.update(newAuthor);
    }


    @Override
    public void delete(long id)
    {
        if (authres.findById(id).isPresent())
        {
            authres.deleteById(id);

        }else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
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
    
    @Override
    public Author findByFname(String fname)
    {
        Author authorFirstName = authres.findByFname(fname);
        
        if(authorFirstName != null)
        {    
        return authorFirstName;
        }else
        {
            throw new EntityNotFoundException(fname);
        }
    }

    @Override
    public Author findByLname(String lname)
    {
        Author authorLastName = authres.findByLname(lname);

        if(authorLastName !=null)
        {
            return authorLastName;
        }else
        {
            throw new EntityNotFoundException(lname);
        }
    }
}
