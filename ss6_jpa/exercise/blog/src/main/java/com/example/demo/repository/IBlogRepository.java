package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository  extends JpaRepository<Blog, Long> {
}
