package com.furama.service;

import com.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> lisContractDetails(Pageable pageable);


    void  saveContractDetail(ContractDetail contractDetail);
}
