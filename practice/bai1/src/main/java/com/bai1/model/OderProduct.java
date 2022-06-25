package com.bai1.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class OderProduct {

    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @Parameter(name = "prefix", value = "CS"),
            strategy = "com.bai1.utils.IdentityCodeGenerator")
    String id;

    @Column(columnDefinition = "DATE")
    String dayBuy;


    @Column(name = "quantity", columnDefinition = "BIGINT")
    Integer quantity;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

    public OderProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
