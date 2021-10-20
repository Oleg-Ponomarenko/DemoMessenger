package com.example.DemoMessenger;

import java.util.ArrayList;

public class Theme {
    private String name;
    private ArrayList<String> comments = new ArrayList<>();

    Theme(String name) {
        this.name = name;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void deleteComment(String comment) {
        comments.remove(comment);
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
