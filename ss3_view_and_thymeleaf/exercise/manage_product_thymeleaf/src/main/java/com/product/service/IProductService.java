package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product customer);

    Product findById(Integer id);

    void update(Product customer);

    void remove(Product customer);

    List<Product> seachingProduct(String name);

}
