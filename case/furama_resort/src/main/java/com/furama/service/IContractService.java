package com.furama.service;

import com.furama.model.Contract;

import java.time.LocalDate;
import java.util.List;

public interface IContractService {

    List<Contract> listContract();
    void  saveContract(Contract contract);
    List<ICustomerVipService> getCustomerVip(LocalDate fromDate, LocalDate toDate);


    List<Contract> searchDay(String dayStart, String dayEnd);
}
