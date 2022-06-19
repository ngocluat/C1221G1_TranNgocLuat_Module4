package com.example.service.impl;


import com.example.model.TypeProduct;
import com.example.repository.ITypeProductReprository;
import com.example.service.ITypeProductSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductSrvice {

    @Autowired
    ITypeProductReprository iTypeProductSrvice;


    @Override
    public List<TypeProduct> listTypeProducts() {
        return iTypeProductSrvice.findAll();
    }
}
