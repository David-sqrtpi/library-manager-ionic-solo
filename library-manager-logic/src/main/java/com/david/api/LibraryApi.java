package com.david.api;

import com.david.entity.Library;
import com.david.services.Database;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryApi {

    private final String collection = "library";

    @PutMapping
    public Library create(@RequestParam(name = "name", defaultValue = "N/A") String name,
                          @RequestParam(name = "email", defaultValue = "N/A") String email){

        Library library = new Library(name, email);
        Database.create(collection, library);

        return library;

    }

    @DeleteMapping("/{document}")
    public String get(@PathVariable("document") String document) {

        Database.delete(collection, document);

        return "Deleted";
    }


}
