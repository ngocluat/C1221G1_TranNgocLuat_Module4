package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idReceipt;

    private String name;

    @OneToMany(mappedBy = "receiptId")
    List<Product> productsList;



    public Receipt() {
    }

    public Receipt(String name) {
        this.name = name;
    }

    public Long getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(Long idReceipt) {
        this.idReceipt = idReceipt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
