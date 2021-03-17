package com.david.application.entity;

public class Library {
    private final String name;
    private final String email;

    public Library(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
