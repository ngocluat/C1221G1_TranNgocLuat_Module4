package com.furama.service.ipml;

import com.furama.model.ContractDetail;
import com.furama.repository.IContractDetailRepository;
import com.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository iContractDetailRepository;

    @Override
    public Page<ContractDetail> lisContractDetails(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
