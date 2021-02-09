package com.david.entity;

public class Book {

    private final String name;
    private final String author;
    private final String isbn;

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public Book() {
        name = "";
        author = "";
        isbn = "";
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
