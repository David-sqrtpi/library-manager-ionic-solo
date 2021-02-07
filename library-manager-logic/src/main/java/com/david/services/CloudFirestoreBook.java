package com.david.services;

public class CloudFirestoreBook {

    private static final String collection = "book";
    private static final CloudFirestore cloudFirestore = new CloudFirestore();

    public static void create(Object payload){
        cloudFirestore.create(collection, payload);
    }

    public static void delete(String document) {
        cloudFirestore.delete(collection, document);
    }

}
