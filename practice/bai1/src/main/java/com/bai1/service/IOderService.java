package com.bai1.service;

import com.bai1.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOderService {

    Page<OderProduct> listOderProducts( String day , Pageable pageable);


    Optional<OderProduct> findByOderCode(Long oderCode );

    void update(OderProduct oderProduct);
}
