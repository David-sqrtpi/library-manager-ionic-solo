package com.david.services;

import com.google.cloud.firestore.DocumentReference;

public class CloudFirestore implements Database{
    @Override
    public static void create(String collection, Object payload) {
        DocumentReference docRef = db.collection(collection).document();

        docRef.set(payload);
    }

    @Override
    public void get() {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete(String collection, String document) {
        // asynchronously delete a document
        db.collection(collection).document(document).delete();
    }
}
