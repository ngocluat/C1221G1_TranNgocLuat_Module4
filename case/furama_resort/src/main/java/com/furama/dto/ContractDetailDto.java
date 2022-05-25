package com.furama.dto;

import com.furama.model.AttachService;
import com.furama.model.Contract;

public class ContractDetailDto {

    AttachService idAttachService;
    Contract contract;
    private Long contractDetailId;
    private Long quantity;

    public ContractDetailDto() {
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

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
