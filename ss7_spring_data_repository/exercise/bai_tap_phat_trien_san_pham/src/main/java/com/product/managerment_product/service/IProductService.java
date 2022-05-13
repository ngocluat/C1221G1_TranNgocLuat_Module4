package com.product.managerment_product.service;

import com.product.managerment_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product customer);

    Product findById(Integer id);

    void update(Product customer);

    void remove(Product customer);

    Page<Product> seachingProduct(String name,String description ,Pageable pageable);

    List<String> getListProduvtCode();

}
