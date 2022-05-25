package com.furama.service.ipml;

import com.furama.model.Contract;
import com.furama.repository.IContractRepository;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public List<Contract> listContract() {
        return iContractRepository.findAll();
    }

    @Override
    public void saveContract(Contract contract) {
        iContractRepository.save(contract);
    }
}
