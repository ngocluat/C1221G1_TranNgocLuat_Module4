package com.example.service.impl;


import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSerrvice implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> listProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }
}
