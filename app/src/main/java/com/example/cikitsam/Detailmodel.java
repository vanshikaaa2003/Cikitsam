package com.example.cikitsam;

public class Detailmodel {
    int id;
    String name, username, email, age, phone, password;

    public Detailmodel(String name, String age, String username) {
        this.name = name;
        this.age = age;
        this.username = username;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }
}