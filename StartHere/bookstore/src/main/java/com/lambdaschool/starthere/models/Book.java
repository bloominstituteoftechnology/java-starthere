package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name ="books")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;
    //primary key
    @Column(nullable = false)
    private String booktitle;
    //the title of the book
    @Column(nullable = false)
    private String ISBN;
    //the ISBN number of the book
    private int copy;
    // the year the book was published (copyright date)



    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }
}
