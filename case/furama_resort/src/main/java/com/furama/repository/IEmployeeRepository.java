package com.furama.repository;

import com.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findByEmployeeNameContainingAndAndEmployeeAddressContainingAndAndEmployeePhoneContaining(String  name , String  address , String phone, Pageable pageable );
}
