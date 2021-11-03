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

    public void updateComment(String comment, String newComment) {
        int i = 0;
        for (String c : comments) {
            if (c.equals(comment)) {
                comments.remove(i);
                comments.add(i, newComment);
            }
            i++;
        }
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
