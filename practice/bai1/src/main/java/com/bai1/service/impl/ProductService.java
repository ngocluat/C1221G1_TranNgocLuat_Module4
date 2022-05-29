package com.bai1.service.impl;

import com.bai1.model.Product;
import com.bai1.repository.IProductRepository;
import com.bai1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public List<Product> listProducts() {
        return iProductRepository.findAll();
    }
}
