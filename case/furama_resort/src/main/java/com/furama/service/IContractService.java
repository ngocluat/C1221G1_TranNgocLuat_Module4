package com.furama.service;

import com.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    List<Contract> listContract();
    void  saveContract(Contract contract);
    List<ICustomerVipService> getCustomerVip();




}
