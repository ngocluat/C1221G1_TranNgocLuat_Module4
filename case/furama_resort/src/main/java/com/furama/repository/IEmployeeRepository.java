package com.furama.repository;

import com.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findByEmployeeNameContainingAndAndEmployeeAddressContainingAndAndEmployeePhoneContaining(String name, String address, String phone, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = " UPDATE employee SET flag = 0 WHERE employee_id= :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);

}
