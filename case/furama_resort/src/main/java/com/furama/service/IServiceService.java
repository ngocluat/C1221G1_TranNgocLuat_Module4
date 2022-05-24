package com.furama.service;

import com.furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {

    Page<Service> listService(Pageable pageable);
    void save (Service service);
}
