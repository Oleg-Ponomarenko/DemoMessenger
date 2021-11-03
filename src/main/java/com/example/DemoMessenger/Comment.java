package com.example.DemoMessenger;

import java.util.Date;

public class Comment {
    private String text;
    private String user;
    private Date date;

    Comment(String text, String user) {
        this.text = text;
        this.user = user;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
}
