package com.chiarapuleio.exercise.dao;

import com.chiarapuleio.exercise.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorDAO extends JpaRepository<Author, UUID> {
    boolean existsByEmail(String email);
}
