package com.product.managerment_product.model;

import javax.persistence.*;

@Entity
@Table(name = "product_orm")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String productCode;
    @Column(name = "name_product")
    String nameProduct;
    String description;
    Double price;
    String dayManufacturing;


    public Product(String nameProduct, String description, Double price, String dayManufacturing) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.dayManufacturing = dayManufacturing;
    }

    public Product( String productCode, String nameProduct, String description, Double price, String dayManufacturing) {
        this.id = id;
        this.productCode = productCode;
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.dayManufacturing = dayManufacturing;
    }

    public Product() {
    }

    public String getDayManufacturing() {
        return dayManufacturing;
    }

    public void setDayManufacturing(String dayManufacturing) {
        this.dayManufacturing = dayManufacturing;
    }

    public Product(String nameProduct, String description, Double price) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public void setIdAutomatic() {

    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
