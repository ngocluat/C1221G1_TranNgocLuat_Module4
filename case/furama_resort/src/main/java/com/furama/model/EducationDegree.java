package com.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationDegreeId;
    private String educationDegreeName;


    public EducationDegree() {
    }

    public EducationDegree(Long educationDegreeId, String educationDegreeName) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
