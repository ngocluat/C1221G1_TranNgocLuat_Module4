package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @JoinColumn(name = "rentId", referencedColumnName = "serviceTypeId")
    @ManyToOne
    ServiceType serviceType;

    @JoinColumn( referencedColumnName = "rentTypeId")
    @ManyToOne
    RentType rentTypeService;

    @OneToMany(mappedBy = "idService")
    List<Contract> idContracts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private String serviceMaxPeople;
    private Double standardRoom;
    private String descriptionOtherConvernience;
    private Double poolArea;
    private Integer numberOffFloors;
    private String rentTypeId;
    private String serviceTypeId;

    public Service() {
    }


    public Service(Long serviceId, String serviceName, Integer serviceArea, Double serviceCost, String serviceMaxPeople, Double standardRoom, String descriptionOtherConvernience, Double poolArea, Integer numberOffFloors, String rentTypeId, String serviceTypeId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvernience = descriptionOtherConvernience;
        this.poolArea = poolArea;
        this.numberOffFloors = numberOffFloors;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public Double getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(Double standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvernience() {
        return descriptionOtherConvernience;
    }

    public void setDescriptionOtherConvernience(String descriptionOtherConvernience) {
        this.descriptionOtherConvernience = descriptionOtherConvernience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOffFloors() {
        return numberOffFloors;
    }

    public void setNumberOffFloors(Integer numberOffFloors) {
        this.numberOffFloors = numberOffFloors;
    }

    public String getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(String rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
