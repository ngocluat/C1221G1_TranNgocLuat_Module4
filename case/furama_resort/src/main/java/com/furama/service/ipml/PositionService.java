package com.furama.service.ipml;

import com.furama.model.Positon;
import com.furama.repository.IPosittionRepository;
import com.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {


    @Autowired
    IPosittionRepository iPosittionRepository;

    @Override
    public List<Positon> listPositons() {
        return iPosittionRepository.findAll();
    }
}
