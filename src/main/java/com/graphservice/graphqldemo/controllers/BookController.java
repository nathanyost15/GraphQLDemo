package com.graphservice.graphqldemo.controllers;

import com.graphservice.graphqldemo.models.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    @QueryMapping
    public Book books(@Argument String name) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Emperors New Groove", UUID.randomUUID().toString()));
        books.add(new Book("Narnia", UUID.randomUUID().toString()));
        return books.stream()
                .filter(book -> name.equalsIgnoreCase(book.getName()))
                .findFirst()
                .orElse(null);
    }
}
