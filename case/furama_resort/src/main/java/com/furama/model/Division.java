package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @OneToMany(mappedBy = "idDivision")
    List<Employee> idEmployees;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;

    public Division() {
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

}
