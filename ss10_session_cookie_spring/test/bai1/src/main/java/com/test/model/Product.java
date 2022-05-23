package com.test.model;

import javax.persistence.*;

@Entity
public class Product {
    @ManyToOne()
    @JoinColumn(referencedColumnName = "idReceipt")
    Receipt receiptId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String price;
    private String quantyti55;
    private String qqdescribe;


    public Product() {
    }

    public Product(String name, String price, String quantyti55, String qqdescribe) {

        this.name = name;
        this.price = price;
        this.quantyti55 = quantyti55;
        this.qqdescribe = qqdescribe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantyti() {
        return quantyti55;
    }

    public void setQuantyti(String quantyti55) {
        this.quantyti55 = quantyti55;
    }

    public String getDescribe() {
        return qqdescribe;
    }

    public void setDescribe(String qqdescribe) {
        this.qqdescribe = qqdescribe;
    }
}
