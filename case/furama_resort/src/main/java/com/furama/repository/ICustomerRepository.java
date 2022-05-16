package com.furama.repository;

import com.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {


    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(String name, String address, String customerCode, Pageable pageable);

}
