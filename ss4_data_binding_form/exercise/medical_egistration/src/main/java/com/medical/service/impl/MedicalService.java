package com.medical.service.impl;

import com.medical.model.Medical;
import com.medical.repository.IRepository;
import com.medical.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IService {
    @Autowired
    IRepository iRepository;

    @Override
    public List<Medical> medicalList() {
        return iRepository.medicalList();
    }

    @Override
    public void addInformationMedical(Medical medical) {
        iRepository.addInformationMedical(medical);
    }
}
