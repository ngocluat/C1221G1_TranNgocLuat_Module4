package com.example.demo.service.impl;

import com.example.demo.model.Post;
import com.example.demo.repository.IPosstRepository;
import com.example.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    IPosstRepository iPosstRepository;



    @Override
    public Page<Post> findAll(Pageable pageable) {
        return iPosstRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return iPosstRepository.findById(id).get();
    }

}
