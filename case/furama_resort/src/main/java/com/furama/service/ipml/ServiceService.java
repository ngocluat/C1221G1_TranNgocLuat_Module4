package com.furama.service.ipml;

import com.furama.model.Service;
import com.furama.repository.IServiecRepository;
import com.furama.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {


    @Autowired
    IServiecRepository iserviecRepository;

    @Override
    public Page<Service> listService(Pageable pageable) {
        return iserviecRepository.findAll(pageable);
    }

    @Override
    public void save(Service service) {
        iserviecRepository.save(service);
    }

}
