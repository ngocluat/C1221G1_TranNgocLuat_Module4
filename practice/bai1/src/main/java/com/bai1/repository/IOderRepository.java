package com.bai1.repository;

import com.bai1.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOderRepository extends JpaRepository<OderProduct, String> {

    @Query(value = "select * from oder_product where day_buy between :dayStart and :dayEnd",
            countQuery = "select * from oder_product where day_buy between :dayStart and :dayEnd",
            nativeQuery = true
    )
    Page<OderProduct> findAllByDayBuyQuery(@Param("dayStart") String dayStart, @Param("dayEnd") String dayEnd, Pageable pageable);


    @Query(value = "select o.* from oder_product o join product p  on o.product_id = p.id    join type_product tp  on p.type_product_id = tp.id_type_product order by quantity * product_price desc",
            countQuery = "select o.* from oder_product o join product p  on o.product_id = p.id    join type_product tp  on p.type_product_id = tp.id_type_product order by quantity * product_price desc", nativeQuery = true)
    Page<OderProduct> findAllTop(Pageable pageable);

}
