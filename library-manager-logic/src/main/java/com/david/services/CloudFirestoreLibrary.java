package com.david.services;

import com.david.entity.Library;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CloudFirestoreLibrary {

    private static final String collection = "library";
    private static final Firestore db = FirestoreClient.getFirestore();

    public static void add(Library payload) {

        DocumentReference docRef = db.collection(collection).document();
        docRef.set(payload);

    }

    public static void delete(String document) {
        db.collection(collection).document(document).delete();
    }

    public static Library get(String document) {
        DocumentReference docRef = db.collection(collection).document(document);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response

        try {
            DocumentSnapshot documentSnapshot = future.get();
            if (documentSnapshot.exists()) {
                // convert document to POJO
                return documentSnapshot.toObject(Library.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //if book doesn't exists
        return null;
    }

    public static ArrayList<Library> getAll() {
        Library library = new Library("hello", "hello");
        ArrayList<Library> libraries= new ArrayList<>();
        libraries.add(library);
        return libraries;
    }

}
