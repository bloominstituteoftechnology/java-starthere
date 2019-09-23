package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value ="Book", description = "The Book Entity")
@Entity
@Table(name ="books")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "bookid", value= "primary key for Book")
    private long bookid;
    //primary key

    @ManyToMany(mappedBy = "book",
                cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")

    @Column(nullable = false)
    @ApiModelProperty(name = "book title", value = "Book Title", required= true, example="Far and away")
    private String booktitle;
    //the title of the book

    @Column(nullable = false)
    @ApiModelProperty(name = "isbn", value = "ISBN", required= true, example="1234")
    private String ISBN;
    //the ISBN number of the book

    @Column(nullable = false)
    @ApiModelProperty(name = "copy", value = "Copy", required= true)
    private int copy;
    // the year the book was published (copyright date)

    public  Book()
    {
    }

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
