package com.bai1.repository;

import com.bai1.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOderRepository extends JpaRepository<OderProduct, Long> {


    Page<OderProduct> findAllByDayBuyContaining(String day, Pageable pageable);


}
