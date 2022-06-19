package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String productName;
    Double productPrice;
    String productStatus;

    @ManyToOne
    @JoinColumn(name = "type_product_id", referencedColumnName = "idTypeProduct")
    TypeProduct typeProduct;

    @OneToMany(mappedBy = "product")
    List<OderProduct> oderProductList;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public List<OderProduct> getOderProductList() {
        return oderProductList;
    }

    public void setOderProductList(List<OderProduct> oderProductList) {
        this.oderProductList = oderProductList;
    }
}
