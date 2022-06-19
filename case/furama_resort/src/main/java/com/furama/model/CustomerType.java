package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(Long customerTypeId, String customerTypeName) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }


    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }


}
