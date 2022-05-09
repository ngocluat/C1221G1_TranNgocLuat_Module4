package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductRepository {


    List<Product> seachingProduct(String name);

    List<Product> findAll();

    Product findOne(Integer id);

    void save(Product Product);

    void delete(Product music);


    void update(Product music);
}

