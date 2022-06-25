package com.furama.dto;

import com.furama.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class CustomerDto implements Validator {

    private String customerId;

    private CustomerType customerType;


    @Pattern(regexp = "^KH\\-[0-9]{4}$", message = " Not Format !! ")
    @NotEmpty(message = "it's not empty ")
    private String customerCode;

    @NotEmpty(message = "name customer in not empty")
    private String customerName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "it's not empty ")
    private String customerBirthDay;

    private Integer customerGender;

    @Pattern(regexp = "^[0-9]{9}$", message = "it not number CMND vietNam, retry ")
    @NotEmpty(message = "it's not empty ")
    private String customerCMDD;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "phone Malformed  ")
    private String customerPhone;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email not regular meeting")
    @NotEmpty(message = "it's not empty ")
    private String customerEmail;

    private String customerAddress;
    private  Integer flag ;


    private List<String> listPhone;
    private List<String> listEmail;


    public CustomerDto() {
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<String> getListEmail() {
        return listEmail;
    }

    public void setListEmail(List<String> listEmail) {
        this.listEmail = listEmail;
    }

    public List<String> getListPhone() {
        return listPhone;
    }

    public void setListPhone(List<String> listPhone) {
        this.listPhone = listPhone;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) (target);
        if (customerDto.getCustomerAddress() == null) {
            errors.rejectValue("customerAddress", "customer.address.null", "errors");
        } else if (customerDto.getCustomerAddress().equals("abc")) {
            errors.rejectValue("customerAddress", "customer.address.null", "errors");
        }
        if (customerDto.getListPhone().contains(customerDto.getCustomerPhone())) {
            errors.rejectValue("customerPhone", "phone.note.duplicate", "Duplicate Customer  Phone");
        }
        if (customerDto.getListEmail().contains(customerDto.getCustomerEmail())) {
            errors.rejectValue("customerEmail", "mail.note.duplicate", "Duplicate Customer  Phone");
        }
        String BirthDay = customerDto.customerBirthDay;
        if (!"".equals(BirthDay)) {
            LocalDate localDate = LocalDate.parse(BirthDay);
            if (LocalDate.now().minusYears(18).isBefore(localDate)) {
                errors.rejectValue("customerBirthDay", "day.before", "errors system");
            }
        }
    }
}
