package com.example.DemoMessenger;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
public class ApiController {

    ArrayList<Theme> themes = new ArrayList<>();

    @PostMapping("themes")
    public void createTheme(@RequestBody String name) {
        themes.add(new Theme(name));
    }

    @DeleteMapping("themes/{name}")
    public void deleteTheme(@PathVariable("name") String name) {
        themes.removeIf(t -> t.getName().equals(name));
    }

    @GetMapping("themes")
    public ArrayList<String> getThemesList() {
        ArrayList<String> names = new ArrayList<>();
        for (Theme t : themes) {
            names.add(t.getName());
        }
        return names;
    }

    @PutMapping("themes/{name}")
    public void updateTheme(@PathVariable("name") String name, @RequestBody String newName) {
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                t.setName(newName);
            }
        }
    }

    @GetMapping("themes/number")
    public int getNumberOfThemes() {
        return themes.toArray().length;
    }

    @DeleteMapping("themes")
    public void deleteAllThemes() {
        themes.clear();
    }

    @GetMapping("themes/{name}")
    public ArrayList<Comment> getTheme(@PathVariable("name") String name) {
        Theme theme = null;
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                theme = t;
            }
        }
        return theme.getFullComments();
    }

    @PostMapping("themes/{name}")
    public void addComment(@PathVariable("name") String name, @RequestBody Comment comment) {
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                t.addComment(comment);
            }
        }
    }

    @DeleteMapping("themes/{name}/{comment}")
    public void deleteComment(@PathVariable("name") String name, @PathVariable("comment") String comment) {
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                for (String c : t.getComments()) {
                    if (c.equals(comment)) {
                        t.deleteComment(c);
                    }
                }
            }
        }
    }

    @PutMapping("themes/{name}/{comment}")
    public void updateComment(@PathVariable("name") String name, @PathVariable("comment") String comment, @RequestBody String newComment) {
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                t.updateComment(comment, newComment);
            }
        }
    }

    @GetMapping("themes/{name}/sort")
    public ArrayList<Comment> getCommentsByDate(@PathVariable("name") String name) {
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                Collections.sort(t.getFullComments(), new Comparator<Comment>() {
                    @Override
                    public int compare(Comment o1, Comment o2) {
                        if (o1.getDate().before(o2.getDate())) {
                            return 1;
                        }
                        else {
                            return -1;
                        }
                    }
                });
                return t.getFullComments();
            }
        }
        return null;
    }
}
