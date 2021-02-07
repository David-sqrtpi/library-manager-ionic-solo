package com.david.api;

import com.david.entity.Library;
import com.david.services.CloudFirestoreLibrary;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryApi {

    @PutMapping
    public Library create(@RequestParam(name = "name", defaultValue = "N/A") String name,
                          @RequestParam(name = "email", defaultValue = "N/A") String email){

        Library library = new Library(name, email);
        CloudFirestoreLibrary.create(library);

        return library;

    }

    @DeleteMapping("/{document}")
    public String get(@PathVariable("document") String document) {

        CloudFirestoreLibrary.delete(document);

        return "Deleted";
    }


}
