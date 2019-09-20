package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;


    @Column(unique = true, nullable= false)
    private String firstname;
    //first name of the author
    private String lastname;
    //last name of the author


    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
}
