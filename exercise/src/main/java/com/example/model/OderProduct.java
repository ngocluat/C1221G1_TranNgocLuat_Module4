package com.example.model;

import javax.persistence.*;

@Entity
public class OderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "DATE")
    String dayBuy;

    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

    public OderProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(String dayBuy) {
        this.dayBuy = dayBuy;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }





}
