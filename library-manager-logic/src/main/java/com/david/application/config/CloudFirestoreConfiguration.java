package com.david.application.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@Configuration
public class CloudFirestoreConfiguration {

    private static FileInputStream setServiceAccount(){

        final String pathToServiceAccount = "C:\\Users\\David\\Downloads\\base-de-datos-a789d-firebase-adminsdk-9u2xv-b9b8ba5993.json";
        try {
            return new FileInputStream(pathToServiceAccount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static FirebaseOptions setOptions() {
        final String databaseUrl = "https://base-de-datos-a789d.firebaseio.com";

        try {

            return FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(Objects.requireNonNull(setServiceAccount())))
                    .setDatabaseUrl(databaseUrl)
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @PostConstruct
    public static void initializeApp(){

        FirebaseApp.initializeApp(Objects.requireNonNull(setOptions()));

    }
}
