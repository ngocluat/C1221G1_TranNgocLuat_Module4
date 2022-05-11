package com.product.managerment_product.repository;


import com.product.managerment_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {



}

