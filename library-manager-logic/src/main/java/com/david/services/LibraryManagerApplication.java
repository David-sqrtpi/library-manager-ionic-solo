package com.david.services;

import com.david.entity.Librarian;
import com.david.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibraryManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagerApplication.class, args);
    }

    @GetMapping("/create")
    public User init(@RequestParam(value = "name", defaultValue = "N/A") String name,
                     @RequestParam(value = "id", defaultValue = "0") int id){

        return new Librarian(name, id);
    }

}
