package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



public interface IPostService {
    Page<Post> findAll(Pageable pageable);


    Post findById(Long id);
}
