package com.david.api;

import com.david.entity.Library;
import com.david.services.CloudFirestoreLibrary;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "*")
public class LibraryApi {

    @PutMapping
    public Library create(@RequestParam(name = "name", defaultValue = "N\\A") String name,
                          @RequestParam(name = "email", defaultValue = "N\\A") String email){

        Library library = new Library(name, email);
        CloudFirestoreLibrary.add(library);

        return library;

    }

    @GetMapping("/{document}")
    public Library get(@PathVariable("document") String document){

        return CloudFirestoreLibrary.get(document);

    }

    @DeleteMapping("/{document}")
    public String delete(@PathVariable("document") String document) {

        CloudFirestoreLibrary.delete(document);

        return "Deleted";
    }


}
