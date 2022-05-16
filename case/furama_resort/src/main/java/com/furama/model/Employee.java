package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @ManyToOne
    @JoinColumn(referencedColumnName = "positionId")
    Positon idPositon;
    @ManyToOne
    @JoinColumn(referencedColumnName = "educationDegreeId")
    EducationDegree idEducationDegree;

    @ManyToOne
    @JoinColumn(referencedColumnName = "divisionId")
    Division idDivision;

    @OneToMany(mappedBy = "idEmployee")
    List<Contract> idContractList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeBirthDay;
    private String employeeCMND;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private Long positionId;
    private Long educationDegreeId;
    private Long divisionId;
    private String userName;


    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String employeeBirthDay, String employeeCMND, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Long positionId, Long educationDegreeId, Long divisionId, String userName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthDay = employeeBirthDay;
        this.employeeCMND = employeeCMND;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.userName = userName;
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

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
