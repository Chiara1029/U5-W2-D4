package com.chiarapuleio.exercise.controllers;

import com.chiarapuleio.exercise.entities.Author;
import com.chiarapuleio.exercise.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authSrv;

    @GetMapping
    public List<Author> getAuthors() {
        return this.authSrv.getAuthors();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable UUID id) {
        return this.authSrv.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {
        return this.authSrv.saveAuthor(newAuthor);
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable UUID id, @RequestBody Author newAuthor) {
        return this.authSrv.findByIdAndUpdate(id, newAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.authSrv.findByIdAndDelete(id);
    }
}