package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value ="bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookres;

    @Override
    public List<Book> findAll()
    {
        List<Book> myBooks = new ArrayList();
        bookres.findAll().iterator().forEachRemaining(myBooks::add);
        return myBooks;
    }

    @Override
    public Book save(Book book)
    {
        book.setBooktitle(book.getBooktitle());
        book.setISBN(book.getISBN());
        return bookres.save(book);
    }
}
