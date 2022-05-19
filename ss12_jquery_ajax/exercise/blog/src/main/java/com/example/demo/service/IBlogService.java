package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> listBlog(Pageable pageable);

    void delete(Blog blog);

    void save(Blog Music);

    void update(Blog music);

    Blog findById(Long id);

//    Page<Blog> findByName(String name);

    Page<Blog> findAllByNameBlogContaining(String name, Pageable pageable);

    Page<Blog> findByNameBlogContainingAndAuthorContaining(String name, String author, Pageable pageable);



}
