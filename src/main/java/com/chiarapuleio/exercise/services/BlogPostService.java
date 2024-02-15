package com.chiarapuleio.exercise.services;

import com.chiarapuleio.exercise.dao.BlogPostDAO;
import com.chiarapuleio.exercise.entities.BlogPost;
import com.chiarapuleio.exercise.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostDAO bpDao;

    public Page<BlogPost> getPosts(int numPages, int size, String orderBy){
        if(size>10) size=10;
        Pageable pageable = PageRequest.of(numPages, size, Sort.by(orderBy));
        return bpDao.findAll(pageable);
    }

    public List<BlogPost> getBlogPosts(){
        return this.bpDao.findAll();
    }

    public BlogPost saveBlogPost(BlogPost newBlogPost) {
        bpDao.save(newBlogPost);
        return newBlogPost;
    }

    public BlogPost findById(UUID id) {
        return bpDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost findByIdAndUpdate(UUID id, BlogPost newBlogPost) {
        BlogPost found = this.findById(id);
        found.setAuthor(newBlogPost.getAuthor());
        found.setCategory(newBlogPost.getCategory());
        found.setTitle(newBlogPost.getTitle());
        found.setCoverUrl(newBlogPost.getCoverUrl());
        found.setContent(newBlogPost.getContent());
        found.setReadingTime(newBlogPost.getReadingTime());
        return bpDao.save(newBlogPost);
    }

    public void findByIdAndDelete(UUID id) {
        BlogPost found = this.findById(id);
        bpDao.delete(found);
    }
}