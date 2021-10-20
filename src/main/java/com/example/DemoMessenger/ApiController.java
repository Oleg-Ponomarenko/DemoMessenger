package com.example.DemoMessenger;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

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
    public ArrayList<String> getTheme(@PathVariable("name") String name) {
        Theme theme = null;
        for (Theme t : themes) {
            if (t.getName().equals(name)) {
                theme = t;
            }
        }
        return theme.getComments();
    }

    /* @PostMapping("themes/{name}")
    public void addComment(@PathVariable String comment) {

    } */
}
