package com.furama.service.ipml;

import com.furama.model.RentType;
import com.furama.repository.IRentServiceRepository;
import com.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    IRentServiceRepository iRentServiceRepository;

    @Override
    public List<RentType> listRent() {
        return iRentServiceRepository.findAll();
    }
}
