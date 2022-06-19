package com.example.service;


import com.example.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOderService {

    Page<OderProduct> listOderProducts(String dayStart, String dayEnd, Pageable pageable);

    Optional<OderProduct> findByOderCode(Long oderCode);

    void update(OderProduct oderProduct);

    Page<OderProduct> top(Pageable pageable);

}
