package com.test.service;

import com.test.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> listProduct();

    void save(Product product);




}
