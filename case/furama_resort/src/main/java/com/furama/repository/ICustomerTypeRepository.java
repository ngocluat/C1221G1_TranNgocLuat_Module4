package com.furama.repository;

import com.furama.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository  extends JpaRepository<CustomerType , Long> {

}
