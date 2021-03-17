package com.david.application.services;

import com.david.application.entity.Book;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CloudFirestoreBook{

    private static final String collection = "book";
    private static final Firestore db = FirestoreClient.getFirestore();

    public static void add(Book payload) {

        DocumentReference docRef = db.collection(collection).document(payload.getIsbn());
        docRef.set(payload);

    }

    public static void delete(String document) {
        db.collection(collection).document(document).delete();
    }

    public static Book get(String document) {
        DocumentReference docRef = db.collection(collection).document(document);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response

        try {
            DocumentSnapshot documentSnapshot = future.get();
            if (documentSnapshot.exists()) {
                // convert document to POJO
                return documentSnapshot.toObject(Book.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //if book doesn't exists
        return null;
    }

    public static ArrayList<Book> getAll() {
        ArrayList<Book> books= new ArrayList<>();

        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection(collection).get();
        // future.get() blocks on response

        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                books.add(document.toObject(Book.class));
            }
            
            return books;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

}
