package com.david.entity;

import org.springframework.web.bind.annotation.RequestParam;

public class AdminService {

    public void addEmployee(@RequestParam(name = "name", defaultValue = "N/A") String name,
                            @RequestParam(name = "id", defaultValue = "0") long id){

        User user = new Librarian(name, id);

    }
}
