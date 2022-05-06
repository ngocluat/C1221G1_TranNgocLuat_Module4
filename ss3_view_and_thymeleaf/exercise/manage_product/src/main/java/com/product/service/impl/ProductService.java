package com.product.service.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> seachingProduct(String name) {
        return iProductRepository.seachingProduct(name);
    }
}
