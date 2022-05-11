package com.product.managerment_product.repository;


import com.product.managerment_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, Integer> {

Page<Product> findAllByNameProductContaining(String name , Pageable pageable );

}

