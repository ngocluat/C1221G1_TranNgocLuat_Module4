package com.furama.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @ManyToOne()
    @JoinColumn(referencedColumnName = "attachServiceId")
    AttachService idAttachService;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "contractId")
    Contract contract;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;


    private Long quantity;

    public ContractDetail() {
    }


    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public AttachService getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(AttachService idAttachService) {
        this.idAttachService = idAttachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
