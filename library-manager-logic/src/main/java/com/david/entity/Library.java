package com.david.entity;

public class Library {
    private final String name;
    private final String employees;

    public Library(String name, String employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public String getEmployees() {
        return employees;
    }

}
