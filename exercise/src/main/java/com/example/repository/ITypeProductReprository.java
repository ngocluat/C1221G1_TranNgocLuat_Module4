package com.example.repository;

import com.example.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeProductReprository extends JpaRepository<TypeProduct, Long> {
}
