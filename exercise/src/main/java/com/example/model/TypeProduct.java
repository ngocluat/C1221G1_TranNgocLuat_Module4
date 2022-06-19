package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTypeProduct;
    String nameTypeProduct;

    @OneToMany(mappedBy = "typeProduct")
    List<Product> productList;




    public Long getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(Long idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
