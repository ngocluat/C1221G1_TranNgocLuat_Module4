package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String namePost;

    @JsonBackReference
    @OneToMany(mappedBy = "post")
    List<Blog> blogList;

    public Post(Long id, String namePost) {
        this.id = id;
        this.namePost = namePost;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

}
