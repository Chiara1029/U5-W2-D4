package com.chiarapuleio.exercise.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record BlogPostDTO(
        @NotEmpty(message = "Category is needed.")
        @Size(min=3, max=10, message = "Category must have at least 3 chars.")
        String category,
        @NotEmpty(message = "Title is needed.")
        @Size(min=3, max=20, message = "Title must have at least 3 chars.")
        String title,
        @NotEmpty(message = "Content is needed.")
        @Size(min=3, max=50, message = "Content must have at least 3 chars.")
        String content,
        @NotEmpty(message = "Reading Time is needed.")
        @Size(min=1, max=3, message = "Reading Time must have at least 1 number.")
        int readingTime,
        @NotEmpty(message = "Cover URL is needed.")
        String coverUrl,
        @NotEmpty(message = "Reading Time is needed.")
        UUID authorId){}

