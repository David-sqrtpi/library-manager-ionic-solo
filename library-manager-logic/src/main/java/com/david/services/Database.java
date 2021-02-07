package com.david.services;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public interface Database {

    Firestore db = FirestoreClient.getFirestore();

    static void create(String collection, Object payload) {

    }

    void get();
    void getAll();
    void update();
    void delete(String collection, String document);

}
