package com.furama.service;

import com.furama.model.Contract;

import java.util.List;

public interface IContractService {

    List<Contract> listContract();
    void  saveContract(Contract contract);
    List<ICustomerVipService> getCustomerVip();




}
