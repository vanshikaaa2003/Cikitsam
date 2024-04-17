package com.example.cikitsam;

public class message {
    private String text;
    private boolean isUser;

    public message(String text, boolean isUser) {
        this.text = text;
        this.isUser = isUser;
    }

    public String getText() {
        return text;
    }

    public boolean isUser() {
        return isUser;
    }
}
