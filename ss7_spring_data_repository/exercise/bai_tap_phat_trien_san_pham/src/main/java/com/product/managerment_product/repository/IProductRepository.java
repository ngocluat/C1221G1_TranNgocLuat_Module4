package com.product.managerment_product.repository;


import com.product.managerment_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByNameProductContainingAndDescriptionContaining(String name, String description, Pageable pageable);

    @Query(value = "select product_code from  product_orm", nativeQuery = true)
    List<String> getCodeProduct();
}

