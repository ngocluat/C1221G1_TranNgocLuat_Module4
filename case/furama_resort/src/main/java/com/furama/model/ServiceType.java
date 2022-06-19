package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {



    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long serviceTypeId;
    private String serviceTypeName;

    public ServiceType() {
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
