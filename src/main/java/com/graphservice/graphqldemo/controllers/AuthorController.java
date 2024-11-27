package com.graphservice.graphqldemo.controllers;

import com.graphservice.graphqldemo.models.Author;
import com.graphservice.graphqldemo.models.Book;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AuthorController {

    @QueryMapping
    public Iterable<Author> authors() {
        List<Author> authors = new ArrayList<>();
        Author csLewis = new Author("C. S. Lewis");
        csLewis.addBook(new Book("Narnia", UUID.randomUUID().toString()));

        Author disney = new Author("disney");
        disney.addBook(new Book("Emperors New Groove", UUID.randomUUID().toString()));
        authors.add(csLewis);
        authors.add(disney);
        return authors;
    }
}
