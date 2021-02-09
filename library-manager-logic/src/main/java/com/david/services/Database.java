package com.david.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public interface Database {

    Firestore db = FirestoreClient.getFirestore();

    static Object get(String collection, String document) {

        DocumentReference docRef = db.collection(collection).document(document);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot documentSnapshot = null;
        try {
            documentSnapshot = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Object object = null;
        if (documentSnapshot.exists()) {
            // convert document to POJO
            object = documentSnapshot.toObject(Object.class);
            System.out.println(object);
        } else {
            System.out.println("No such document!");
        }

        return object;

    };

}
