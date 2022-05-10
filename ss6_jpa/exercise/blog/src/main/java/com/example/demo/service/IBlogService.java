package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> listBlog();

    void delete(Blog blog);


    void save(Blog Music);


    void update(Blog music);


    Blog findById(Long id);
}
