package com.david.api;

import com.david.config.CloudFirestoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagerApplication {

    public static void main(String[] args) {

        CloudFirestoreConfiguration.initializeApp();
        SpringApplication.run(LibraryManagerApplication.class, args);
    }

}
