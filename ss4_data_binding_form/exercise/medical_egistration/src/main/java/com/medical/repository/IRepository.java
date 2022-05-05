package com.medical.repository;

import com.medical.model.Medical;

import java.util.List;

public interface IRepository {
    List<Medical> medicalList();

    void addInformationMedical( Medical medical);
}
