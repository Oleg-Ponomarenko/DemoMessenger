package com.example.DemoMessenger;

import java.util.ArrayList;

public class Theme {
    private String name;
    private ArrayList<Comment> comments = new ArrayList<>();

    Theme(String name) {
        this.name = name;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(String comment) {
        int i = 0;
        for (Comment c : comments) {
            if (c.getText().equals(comment)) {
                comments.remove(i);
            }
            i++;
        }
    }

    public void updateComment(String comment, String newComment) {
        int i = 0;
        for (Comment c : comments) {
            if (c.getText().equals(comment)) {
                comments.remove(i);
                comments.add(i, new Comment(comment, c.getUser()));
            }
            i++;
        }
    }

    public ArrayList<String> getComments() {
        ArrayList<String> s = new ArrayList<>();
        for (Comment c : comments) {
            s.add(c.getText());
        }
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Comment> getFullComments() {
        return comments;
    }
}
