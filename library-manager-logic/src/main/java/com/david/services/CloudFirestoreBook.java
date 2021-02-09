package com.david.services;

import com.david.entity.Book;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
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
        Book book = new Book("hello", "hello", "hello");
        ArrayList<Book> books= new ArrayList<>();
        books.add(book);
        return books;
    }

}
