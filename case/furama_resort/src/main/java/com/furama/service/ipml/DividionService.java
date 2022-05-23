package com.furama.service.ipml;

import com.furama.model.Division;
import com.furama.repository.IDivisionRepositiory;
import com.furama.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividionService implements IDivisionService {

    @Autowired
    IDivisionRepositiory iDivisionRepositiory;

    @Override
    public List<Division> listDivisions() {
        return iDivisionRepositiory.findAll();
    }
}
