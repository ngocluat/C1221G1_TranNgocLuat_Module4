package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByNameBlogContaining(String name, Pageable pageable);


    Page<Blog> findByNameBlogContainingAndAuthorContaining(String name, String author, Pageable pageable);


}
