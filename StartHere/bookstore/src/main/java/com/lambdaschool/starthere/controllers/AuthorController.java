package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorController
{
    @Autowired
    private AuthorService authorService;
}
