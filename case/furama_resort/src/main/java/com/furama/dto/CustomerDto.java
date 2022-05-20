package com.furama.dto;

public class CustomerDto {
    private Long customerId;

    private Integer customerTypeId;

    private String customerCode;
    private String customerName;
    private String customerBirthDay;
    private Integer customerGender;
    private String customerCMDD;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;


    public CustomerDto() {
    }

    public CustomerDto(Integer customerTypeId, String customerCode, String customerName, String customerBirthDay, Integer customerGender, String customerCMDD, String customerPhone, String customerEmail, String customerAddress) {
        this.customerTypeId = customerTypeId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerCMDD = customerCMDD;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerCMDD() {
        return customerCMDD;
    }

    public void setCustomerCMDD(String customerCMDD) {
        this.customerCMDD = customerCMDD;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", customerTypeId=" + customerTypeId +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerBirthDay='" + customerBirthDay + '\'' +
                ", customerGender=" + customerGender +
                ", customerCMDD='" + customerCMDD + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
