package com.bai1.dto;

import com.bai1.model.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OderProductDto {

    Long id;

    @NotEmpty(message = "not null !! ")
    String dayBuy;

    @NotNull(message = "not null !! ")
    Integer quantity;
    Product product;

    public OderProductDto() {
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
