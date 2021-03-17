package com.david.application.api;

import com.david.application.entity.Librarian;
import com.david.application.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminApi {

    @Autowired
    private LibrarianService librarianService;

    @PostMapping("add-librarian")
    public Librarian addLibrarian(Librarian librarian){
        return librarianService.addLibrarian(librarian);
    }
}
