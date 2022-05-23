package com.furama.service.ipml;

import com.furama.model.EducationDegree;
import com.furama.repository.IEducationRepository;
import com.furama.service.IEducattionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationService implements IEducattionService {

    @Autowired
    IEducationRepository iEducationRepository;
    @Override
    public List<EducationDegree> lisEducationDegree() {
        return iEducationRepository.findAll();
    }
}
