package com.david.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

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

    public static void initializeApp(){

        FirebaseApp.initializeApp(Objects.requireNonNull(setOptions()));

    }
}
