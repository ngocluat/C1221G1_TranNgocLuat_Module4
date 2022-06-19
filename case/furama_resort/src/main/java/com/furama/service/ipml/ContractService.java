package com.furama.service.ipml;

import com.furama.model.Contract;
import com.furama.repository.IContractRepository;
import com.furama.service.IContractService;
import com.furama.service.ICustomerVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public List<ICustomerVipService> getCustomerVip(LocalDate fromDate, LocalDate toDate) {
        String startBegin = "";
        String startEnd = "";
        String endBegin = "";
        String end = "";

        if (fromDate == null && toDate == null) {
            startEnd = LocalDate.now().plusYears(1).toString();
            end = LocalDate.now().plusYears(1).toString();
        } else if (fromDate != null && toDate != null) {
            startBegin = fromDate.toString();
            startEnd = toDate.toString();
            end = toDate.toString();
        } else if (fromDate != null) {
            startBegin = fromDate.toString();
            startEnd = LocalDate.now().plusYears(1).toString();
            end = LocalDate.now().plusYears(1).toString();
        } else {
            startEnd = toDate.toString();
            end = toDate.toString();
        }
        return iContractRepository.getCustomerVipList(startBegin, startEnd, endBegin, end);
    }

    @Override
    public List<Contract> searchDay(String dayStart, String dayEnd) {
        LocalDate localDate = LocalDate.now();
        if (dayStart == null) {
            return iContractRepository.search("", dayEnd);
        } else if (dayEnd == null) {
            return iContractRepository.search(dayStart, "");
        } else if (dayStart != null && dayEnd != null) {
            return iContractRepository.search(dayStart, localDate.toString());
        } else {
            return iContractRepository.search(dayStart, dayEnd);
        }
    }
}
