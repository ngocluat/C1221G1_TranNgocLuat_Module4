package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {
    @OneToMany(mappedBy = "idAttachService")
    List<ContractDetail> idContractDetails;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachServiceId;
    private String attachServiceName;
    private Double attachServiceCost;
    private Integer attachServiceUnit;
    private String attachServiceStatus;

    public AttachService() {
    }

    public AttachService(String attachServiceName, Double attachServiceCost, Integer attachServiceUnit, String attachServiceStatus) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public Long getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Long attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
