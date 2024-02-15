package com.chiarapuleio.exercise.dao;

import com.chiarapuleio.exercise.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogPostDAO extends JpaRepository<BlogPost, UUID> {
}