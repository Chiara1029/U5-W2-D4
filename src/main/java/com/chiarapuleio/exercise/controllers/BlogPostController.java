package com.chiarapuleio.exercise.controllers;

import com.chiarapuleio.exercise.entities.BlogPost;
import com.chiarapuleio.exercise.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService bpSrv;

    @GetMapping
    public Page<BlogPost> getAllPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "title") String orderBy) {
        return this.bpSrv.getPosts(page, size, orderBy);
    }


    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable UUID id) {
        return this.bpSrv.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost savePost(@RequestBody BlogPost newPost) {
        return this.bpSrv.saveBlogPost(newPost);
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable UUID id, @RequestBody BlogPost newPost) {
        return this.bpSrv.findByIdAndUpdate(id, newPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.bpSrv.findByIdAndDelete(id);
    }
}