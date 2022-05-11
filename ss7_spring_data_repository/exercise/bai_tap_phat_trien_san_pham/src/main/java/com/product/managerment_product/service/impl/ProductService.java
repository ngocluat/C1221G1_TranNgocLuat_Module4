package com.product.managerment_product.service.impl;


import com.product.managerment_product.model.Product;
import com.product.managerment_product.repository.IProductRepository;
import com.product.managerment_product.service.IProductService;
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
    public Product findById(Integer id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        iProductRepository.delete(product);
    }

//    @Override
//    public List<Product> seachingProduct(String name) {
//        return iProductRepository. (name);
//    }
}
