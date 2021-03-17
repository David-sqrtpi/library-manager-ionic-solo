package com.david.application;

import com.david.application.config.CloudFirestoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class LibraryManagerApplication {

        public static void main(String[] args) {

        CloudFirestoreConfiguration.initializeApp();
        SpringApplication.run(LibraryManagerApplication.class, args);

    }

}
