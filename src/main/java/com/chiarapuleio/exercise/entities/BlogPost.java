package com.chiarapuleio.exercise.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String category;
    private String title;
    @Column(name="cover_url")
    private String coverUrl;
    private String content;
    @Column(name="reading_time")
    private int readingTime;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    public BlogPost(String category, String title, String coverUrl, String content, int readingTime, Author author) {
        this.category = category;
        this.title = title;
        this.coverUrl = coverUrl;
        this.content = content;
        this.readingTime = readingTime;
        this.author = author;
    }
}
