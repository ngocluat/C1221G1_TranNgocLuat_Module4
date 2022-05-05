package com.medical.service;

import com.medical.model.Medical;

import java.util.List;

public interface IService {
    List<Medical> medicalList();

    void addInformationMedical( Medical medical);
}
