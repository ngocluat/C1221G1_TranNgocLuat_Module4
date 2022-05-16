package com.furama.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContractDetail {
    @ManyToOne()
    @JoinColumn(referencedColumnName = "attachServiceId")
    AttachService idAttachService;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "contractId")
    Contract contract;
    @Id
    private Long contractDetailId;
    private Long contractId;
    private Long attachSerrviceId;
    private Long quantity;

    public ContractDetail() {
    }

    public ContractDetail(Long contractId, Long attachSerrviceId, Long quantity) {
        this.contractId = contractId;
        this.attachSerrviceId = attachSerrviceId;
        this.quantity = quantity;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getAttachSerrviceId() {
        return attachSerrviceId;
    }

    public void setAttachSerrviceId(Long attachSerrviceId) {
        this.attachSerrviceId = attachSerrviceId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
