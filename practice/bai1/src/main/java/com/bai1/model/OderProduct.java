package com.bai1.model;

import javax.persistence.*;

@Entity
public class OderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String dayBuy;
    Integer quantity;
    @ManyToOne
    Product productCode;

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

    public Product getProductCode() {
        return productCode;
    }

    public void setProductCode(Product productCode) {
        this.productCode = productCode;
    }


}
