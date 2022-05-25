package com.furama.dto;

import com.furama.model.Contract;
import com.furama.model.RentType;
import com.furama.model.ServiceType;

import java.util.List;

public class ServiceDto {
    private Long serviceId;

    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private String serviceMaxPeople;
    private String standardRoom;

    private String descriptionOtherConvernience;
    private Double poolArea;
    private Integer numberOffFloors;
    String serviceFree;
    List<Contract> idContracts;

    RentType rentTypeService;


    ServiceType serviceType;

    public ServiceDto() {
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

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvernience() {
        return descriptionOtherConvernience;
    }

    public void setDescriptionOtherConvernience(String descriptionOtherConvernience) {
        this.descriptionOtherConvernience = descriptionOtherConvernience;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
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

    public List<Contract> getIdContracts() {
        return idContracts;
    }

    public void setIdContracts(List<Contract> idContracts) {
        this.idContracts = idContracts;
    }

    public RentType getRentTypeService() {
        return rentTypeService;
    }

    public void setRentTypeService(RentType rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
