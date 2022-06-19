package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentTypeId;
    private String RentTypeName;

    public RentType() {
    }

    public RentType(Long rentTypeId, String rentTypeName) {
        this.rentTypeId = rentTypeId;
        RentTypeName = rentTypeName;
    }

    public Long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return RentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        RentTypeName = rentTypeName;
    }
}
