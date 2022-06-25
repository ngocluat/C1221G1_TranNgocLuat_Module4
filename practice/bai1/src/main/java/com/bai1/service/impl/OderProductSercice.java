package com.bai1.service.impl;

import com.bai1.model.OderProduct;
import com.bai1.repository.IOderRepository;
import com.bai1.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OderProductSercice implements IOderService {


    @Autowired
    IOderRepository iOderRepository;

    @Override
    public Page<OderProduct> listOderProducts(String dayStart, String dayEnd, Pageable pageable) {

        if (dayStart.equals("") && dayEnd.equals("")) {
            return iOderRepository.findAll(pageable);
        } else if (!dayStart.equals("") && !dayEnd.equals("")) {
            return iOderRepository.findAllByDayBuyQuery(dayStart, dayEnd, pageable);
        } else if (!dayStart.equals("")) {
            return iOderRepository.findAllByDayBuyQuery(dayStart, LocalDate.now().plusYears(100).toString(), pageable);
        } else {
            return iOderRepository.findAllByDayBuyQuery("", dayEnd, pageable);
        }


    }

    @Override
    public Optional<OderProduct> findByOderCode(String oderCode) {
        return iOderRepository.findById(oderCode);
    }

    @Override
    public void update(OderProduct oderProduct) {
        iOderRepository.save(oderProduct);
    }

    @Override
    public Page<OderProduct> top(Pageable pageable) {
        return iOderRepository.findAllTop(pageable);
    }


}
