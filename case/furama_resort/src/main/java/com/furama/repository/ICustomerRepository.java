package com.furama.repository;

import com.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {


    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(String name, String address, String customerCode, Pageable pageable);

    @Query(value = "select customer_phone from customer ",  nativeQuery = true)
    List<String> findAllListPhone();

    @Query(value = "select * from customer where customer_name like :searchName and customer_email like :searchEmail and id_customer_type like:searchType  and flag=1",
            countQuery = "select count(*) from customer where customer_name like :searchName and customer_email like :searchEmail and id_customer_type like:searchType and flag=1 ",
            nativeQuery = true)
    Page<Customer> findAllAndSearch(
            @Param("searchName") String searchName,
            @Param("searchEmail") String searchEmail,
            @Param("searchType") String searchType,
            Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "UPDATE customer SET flag = 0 WHERE customer_id = :id", nativeQuery = true)
    void deteCustomer(@Param("id") Long id);
}
