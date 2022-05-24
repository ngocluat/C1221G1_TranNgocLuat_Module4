package com.furama.repository;

import com.furama.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeService extends JpaRepository<ServiceType, Long> {
}
