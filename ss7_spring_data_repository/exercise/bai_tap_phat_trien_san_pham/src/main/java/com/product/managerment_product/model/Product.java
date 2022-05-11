package com.product.managerment_product.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "product_orm")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name_product")
    String nameProduct;
    String description;
    Double price;


    public Product(Integer id, String nameProduct, String description, Double price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
    }

    public Product() {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }


}
