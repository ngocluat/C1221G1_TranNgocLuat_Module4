package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPosstRepository extends JpaRepository<Post, Long> {
}
