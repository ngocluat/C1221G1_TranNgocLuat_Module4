package com.test.repository;

import com.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  extends JpaRepository<Product , Long > {
}
