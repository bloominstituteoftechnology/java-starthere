package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value ="bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookres;

    @Override
    public List<Book> findAll(Pageable pageable)
    {
        List<Book> myBooks = new ArrayList();
        bookres.findAll().iterator().forEachRemaining(myBooks::add);
        return myBooks;
    }

    @Override
    public Book findBookById(long id)
    {
        return bookres.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id)
    {
        if(bookres.findById(id).isPresent())
        {
            bookres.deleteById(id);
        }else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Book update(Book book, long id)
    {
        Book newBook = bookres.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getBooktitle() !=null)
        {
            newBook.setBooktitle(book.getBooktitle());
        }

        return bookres.save(newBook);
    }

    @Transactional
    @Override
    public Book save(Book book)
    {
        book.setBookid(book.getBookid());
        book.setBooktitle(book.getBooktitle());
        book.setISBN(book.getISBN());
        book.setCopy(book.getCopy());
        return bookres.save(book);
    }

}
