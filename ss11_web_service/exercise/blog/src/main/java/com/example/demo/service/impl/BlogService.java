package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Post;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }




    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public void save(Blog blog) {

        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).get();
    }

//    @Override
//    public Page<Blog> findByName(String name) {
//        return iBlogRepository.findByName("%" + name + "%");
//    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String name, Pageable pageable) {
        return iBlogRepository.findAllByNameBlogContaining(name, pageable);

    }



}

