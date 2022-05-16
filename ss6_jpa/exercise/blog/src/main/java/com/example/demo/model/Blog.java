package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameBlog;
    private String content;
    private String author;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    public Blog() {
    }

    public Blog(String nameBlog, String content, String author) {
        this.nameBlog = nameBlog;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
