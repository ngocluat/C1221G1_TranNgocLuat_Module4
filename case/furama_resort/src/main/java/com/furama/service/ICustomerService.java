package com.furama.service;

import com.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAllCustomer(Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(String name, String address, String customerCode, Pageable pageable);


    void save(Customer customer);

    Customer findById(Long id);

    void update(Customer customer);

    void remove(Long customer);

    Page<Customer> seachingCustomer(String name, String description, Pageable pageable);

    List<String> getListPhone();

    Page<Customer> findAllAndSearch(String searchName, String searchEmail, String searchType, Pageable pageable);
}


