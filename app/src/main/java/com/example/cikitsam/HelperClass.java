package com.example.cikitsam;

public class HelperClass {
    String name,username,email,age,phonenumber,password;

    public HelperClass() {
    }

    public HelperClass(String name, String username, String email, String age, String phonenumber, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.age = age;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
