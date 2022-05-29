package com.bai1.service.impl;

import com.bai1.model.OderProduct;
import com.bai1.repository.IOderRepository;
import com.bai1.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OderProductSercice implements IOderService {


    @Autowired
    IOderRepository iOderRepository;

    @Override
    public Page<OderProduct> listOderProducts(String day , Pageable pageable) {
        return iOderRepository.findAllByDayBuyContaining(day, pageable);
    }

    @Override
    public Optional<OderProduct> findByOderCode(Long oderCode) {
        return iOderRepository.findById(oderCode);
    }

    @Override
    public void update(OderProduct oderProduct) {
        iOderRepository.save(oderProduct);
    }


}
