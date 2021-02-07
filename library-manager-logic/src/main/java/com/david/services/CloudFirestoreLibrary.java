package com.david.services;

import com.google.cloud.firestore.DocumentReference;

public class CloudFirestoreLibrary{

    private static final String collection = "library";
    private static final CloudFirestore cloudFirestore = new CloudFirestore();

    public static void create(Object payload) {

        cloudFirestore.create(collection, payload);

    }

    public void get() {

    }

    public void getAll() {

    }

    public void update() {

    }

    public static void delete(String document) {
        cloudFirestore.delete(collection, document);
    }
}
