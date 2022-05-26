package com.furama.dto;

import com.furama.model.ContractDetail;
import com.furama.model.Customer;
import com.furama.model.Employee;
import com.furama.model.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ContractDto implements Validator {

    private Long contractId;
    @NotNull(message = "not null !! ")
    private String contractStartDay;
    private String contractEndDay;
    private Double contractDeposit;
    private Double contractToTalMoney;
    List<ContractDetail> contractDetails;
    @NotNull(message = "not null !! ")
    Service idService;
    @NotNull(message = "not null !! ")
    Customer idCustomer;
    @NotNull(message = "not null !! ")
    Employee idEmployee;


    public ContractDto() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractToTalMoney() {
        return contractToTalMoney;
    }

    public void setContractToTalMoney(Double contractToTalMoney) {
        this.contractToTalMoney = contractToTalMoney;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.getIdCustomer()== null){
            errors.rejectValue("idCustomer", "err.err", "errors");
        }
    }
}
