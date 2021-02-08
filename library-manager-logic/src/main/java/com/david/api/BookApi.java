package com.david.api;

import com.david.entity.Book;
import com.david.services.Database;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookApi {

    private final String collection = "book";

    @PutMapping
    public Book create(@RequestParam(name = "name", defaultValue = "N/A") String name,
                          @RequestParam(name = "author", defaultValue = "N/A") String author,
                          @RequestParam(name = "isbn", defaultValue = "N/A") String isbn){

        Book book = new Book(name, author, isbn);
        Database.create(collection, book);
        return book;

    }

    @DeleteMapping("/{document}")
    public String get(@PathVariable("document") String document) {

        Database.delete(collection, document);

        return "Deleted";
    }


}
