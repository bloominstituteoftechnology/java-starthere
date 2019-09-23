package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "Author", description ="The Author Entity")
@Entity
@Table(name = "authors")
public class Author extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;


    @ManyToMany(mappedBy = "author ",
                cascade = CascadeType.ALL)
    @JsonIgnoreProperties("author")

    @ApiModelProperty(name = "first name", value = "First Name", required= true, example="Michael")
    @Column(unique = true, nullable= false)
    private String fname;
    //first name of the author

    @ApiModelProperty(name = "last name", value = "Last Name", required= true, example="Johnson")
    @Column(unique = true, nullable = false)
    private String lname;
    //last name of the author

    public Author()
    {
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }
}
