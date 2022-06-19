package com.bai1.service.impl;

import com.bai1.model.TypeProduct;
import com.bai1.repository.ITypeProductReprository;
import com.bai1.service.ITypeProductSrvice;
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
