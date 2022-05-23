package com.furama.service.ipml;

import com.furama.model.Employee;
import com.furama.repository.IEmployeeRepository;
import com.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSerrvice implements IEmployeeService {


    @Autowired
    IEmployeeRepository iEmployeeRepository;


    @Override
    public Page<Employee> findAllEmployees(String name, String address, String phone, Pageable pageable) {
        return iEmployeeRepository.findByEmployeeNameContainingAndAndEmployeeAddressContainingAndAndEmployeePhoneContaining(name, address, phone, pageable);
    }


    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        iEmployeeRepository.delete(employee);
    }


}
