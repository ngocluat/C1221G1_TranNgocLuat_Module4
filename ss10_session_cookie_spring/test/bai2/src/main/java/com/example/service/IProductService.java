package com.example.service;


import com.example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> listProduct();

    void save(Product product);

Product findById(Long id);


}
