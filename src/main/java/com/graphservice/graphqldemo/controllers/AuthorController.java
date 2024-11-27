package com.graphservice.graphqldemo.controllers;

import com.graphservice.graphqldemo.models.Author;
import com.graphservice.graphqldemo.models.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AuthorController {

    @QueryMapping
    public Author authors(@Argument String name) {
        List<Author> authors = new ArrayList<>();
        Author csLewis = new Author("C. S. Lewis");
        csLewis.addBook(new Book("Narnia", UUID.randomUUID().toString()));
        csLewis.addBook(new Book("The problem of Pain", UUID.randomUUID().toString()));
        csLewis.addBook(new Book("The four loves", UUID.randomUUID().toString()));

        Author disney = new Author("disney");
        disney.addBook(new Book("Emperors New Groove", UUID.randomUUID().toString()));
        authors.add(csLewis);
        authors.add(disney);
        return authors.stream()
                .filter(author -> name.equalsIgnoreCase(author.getName()))
                .findFirst()
                .orElse(null);
    }
}
