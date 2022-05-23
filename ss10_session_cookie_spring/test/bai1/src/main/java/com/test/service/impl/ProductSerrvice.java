package com.test.service.impl;

import com.test.model.Product;
import com.test.repository.IProductRepository;
import com.test.service.IProductService;
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
}
