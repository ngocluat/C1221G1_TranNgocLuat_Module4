package com.furama.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    private String employeeCode;
    private String employeeName;
    private String employeeBirthDay;
    private String employeeCMND;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @JoinColumn()
    @ManyToOne()
    private AppUser userName;
    private Integer flag;

    public Employee() {
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

    public AppUser getUserName() {
        return userName;
    }

    public void setUserName(AppUser userName) {
        this.userName = userName;
    }

    public Positon getIdPositon() {
        return idPositon;
    }

    public void setIdPositon(Positon idPositon) {
        this.idPositon = idPositon;
    }

    public EducationDegree getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(EducationDegree idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public Division getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Division idDivision) {
        this.idDivision = idDivision;
    }


    public List<Contract> getIdContractList() {
        return idContractList;
    }

    public void setIdContractList(List<Contract> idContractList) {
        this.idContractList = idContractList;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeId(), employee.getEmployeeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId());
    }
}
