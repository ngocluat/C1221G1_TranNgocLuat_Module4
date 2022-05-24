package com.furama.dto;

import com.furama.model.Division;
import com.furama.model.EducationDegree;
import com.furama.model.Positon;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeDto implements Validator {

    private static final String DAYOFBIRTH = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    private static final String MAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String NAME = "^[\\p{Lu}\\p{Ll}\\s]{5,50}$";
    private static final String EMPLOYEECODE = "^NV\\-\\d{4}$";
    private static final String CMND = "[0-9]{9}$";
    @NotNull(message = "it not isEmpty ")
    Positon idPositon;

    @NotNull(message = "it not isEmpty ")
    Division idDivision;

    @NotNull(message = "it not isEmpty ")
    EducationDegree idEducationDegree;


    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeBirthDay;
    private String employeeCMND;
    private Double employeeSalary;
    private String employeePhone;
    @NotEmpty(message = "not allowed to plant this umbrella!! ")
    private String employeeEmail;

    private String employeeAddress;
    private String userName;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeName, String employeeBirthDay, String employeeCMND, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, String userName) {
        this.employeeName = employeeName;
        this.employeeBirthDay = employeeBirthDay;
        this.employeeCMND = employeeCMND;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.userName = userName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeCMND() {
        return employeeCMND;
    }

    public void setEmployeeCMND(String employeeCMND) {
        this.employeeCMND = employeeCMND;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Positon getIdPositon() {
        return idPositon;
    }

    public void setIdPositon(Positon idPositon) {
        this.idPositon = idPositon;
    }

    public Division getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Division idDivision) {
        this.idDivision = idDivision;
    }

    public EducationDegree getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(EducationDegree idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBirthDay='" + employeeBirthDay + '\'' +
                ", employeeCMND='" + employeeCMND + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;

        salaryValidid(errors, employeeDto);
        birthValidid(errors, employeeDto);
        mailValidid(errors, employeeDto);
        nameValidid(errors, employeeDto);
        employeeCodeValidid(errors, employeeDto);
        cmndValidid(errors, employeeDto);

    }


    private void cmndValidid(Errors errors, EmployeeDto employeeDto) {
        if (!employeeDto.getEmployeeCMND().matches(CMND)) {
            errors.rejectValue("employeeCMND", "cmnd.employee", "errors");
        } else if (employeeDto.getEmployeeCMND() == null) {
            errors.rejectValue("employeeEmail", "is.empty", "errors");
        }
    }

    private void employeeCodeValidid(Errors errors, EmployeeDto employeeDto) {
        if (!employeeDto.getEmployeeCode().matches(EMPLOYEECODE)) {
            errors.rejectValue("employeeCode", "code.employee", "errors");
        } else if (employeeDto.getEmployeeCode() == null) {
            errors.rejectValue("employeeEmail", "is.empty", "errors");
        }
    }

    private void nameValidid(Errors errors, EmployeeDto employeeDto) {
        if (!employeeDto.getEmployeeName().matches(NAME)) {
            errors.rejectValue("employeeName", "name.validate", "errors");
        } else if (employeeDto.getEmployeeName() == null) {
            errors.rejectValue("employeeEmail", "is.empty", "errors");
        }
    }

    private void mailValidid(Errors errors, EmployeeDto employeeDto) {
        if (!employeeDto.getEmployeeEmail().matches(MAIL)) {
            errors.rejectValue("employeeEmail", "mail.format", "errors");
        } else if (employeeDto.getEmployeeEmail() == null) {
            errors.rejectValue("employeeEmail", "is.empty", "errors");
        }
    }

    private void birthValidid(Errors errors, EmployeeDto employeeDto) {
//        if (!employeeDto.getEmployeeBirthDay().matches(DAYOFBIRTH)) {
//            errors.rejectValue("employeeBirthDay", "day.format", "errors");
//        } else
            if (employeeDto.getEmployeeBirthDay() == null) {
            errors.rejectValue("employeeEmail", "is.empty", "errors");
        }
    }


    private void salaryValidid(Errors errors, EmployeeDto employeeDto) {
        if (employeeDto.getEmployeeSalary() == null) {
            errors.rejectValue("employeeSalary", "salari.null", "errors");
        } else if (employeeDto.getEmployeeSalary() == 0) {
            errors.rejectValue("employeeSalary", "salari.small", "errors");
        }
    }
}
