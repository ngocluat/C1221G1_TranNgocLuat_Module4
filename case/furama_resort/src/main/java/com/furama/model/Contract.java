package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @ManyToOne
    @JoinColumn(referencedColumnName = "employeeId")
    Employee idEmployee;

    @ManyToOne
    @JoinColumn(referencedColumnName = "customerId")
    Customer idCustomer;

    @ManyToOne
    @JoinColumn(referencedColumnName = "serviceId")
    Service idService;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> contractDetails;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    private String contractStartDay;
    private String contractEndDay;
    private Double contractDeposit;
    private Double contractToTalMoney;
    private Long employeeId;
    private Long customerId;
    private Long serviceId;


    public Contract() {
    }

    public Contract(String contractStartDay, String contractEndDay, Double contractDeposit, Double contractToTalMoney, Long employeeId, Long customerId, Long serviceId) {
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractToTalMoney = contractToTalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
