package com.graphservice.graphqldemo;

import com.graphservice.graphqldemo.models.Book;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    @QueryMapping
    public Iterable<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Emperors New Groove"));
        books.add(new Book("Narnia"));
        addIsbns(books);
        return books;
    }

    private void addIsbns(List<Book> books) {
        for (Book book : books) {
            book.setIsbn(UUID.randomUUID().toString());
        }
    }
}
