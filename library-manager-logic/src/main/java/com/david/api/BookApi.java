package com.david.api;

import com.david.entity.Book;
import com.david.services.CloudFirestoreBook;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookApi {

    @PutMapping
    public Book create(@RequestParam(name = "name", defaultValue = "N\\A") String name,
                          @RequestParam(name = "author", defaultValue = "N\\A") String author,
                          @RequestParam(name = "isbn", defaultValue = "N\\A") String isbn){

        Book book = new Book(name, author, isbn);
        CloudFirestoreBook.add(book);
        return book;

    }

    @GetMapping("/{document}")
    public Book get(@PathVariable("document") String document){

        return CloudFirestoreBook.get(document);

    }

    @GetMapping
    public ArrayList<Book> getAll() {

        return CloudFirestoreBook.getAll();

    }


    @DeleteMapping("/{document}")
    public String delete(@PathVariable("document") String document) {

        CloudFirestoreBook.delete(document);

        return "Deleted";
    }

    @PatchMapping("/{document}")
    public String update(@RequestParam(name = "field", defaultValue = "N\\A") String field) {
        
        return "Updated";
    }


}
