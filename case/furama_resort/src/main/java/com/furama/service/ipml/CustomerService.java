package com.furama.service.ipml;

import com.furama.model.Customer;
import com.furama.repository.ICustomerRepository;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {


    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(String name, String address, String customerCode, Pageable pageable) {
        return iCustomerRepository.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerCodeContaining(name, address, customerCode, pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.getById(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        iCustomerRepository.delete(customer);

    }

    @Override
    public Page<Customer> seachingCustomer(String name, String description, Pageable pageable) {
        return null;
    }

    @Override
    public List<String> getListProductCode() {
        return null;
    }


}
