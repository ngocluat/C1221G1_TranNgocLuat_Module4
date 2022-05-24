package com.furama.service.ipml;

import com.furama.model.ServiceType;
import com.furama.repository.ITypeService;
import com.furama.service.ITypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceService implements ITypeServiceService {


    @Autowired
    ITypeService iTypeService;
    @Override
    public List<ServiceType> listSeviceType() {
        return iTypeService.findAll();
    }
}
