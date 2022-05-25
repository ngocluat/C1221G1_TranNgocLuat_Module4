package com.furama.service;

import com.furama.model.Employee ;
import com.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllEmployees(String name , String address , String phone,Pageable pageable);

    Page<Employee> findEmployees(Pageable pageable);

    void save(Employee employee);

    Employee findById(Long id);

    void update(Employee employee);

    void remove(Employee employee);


}
