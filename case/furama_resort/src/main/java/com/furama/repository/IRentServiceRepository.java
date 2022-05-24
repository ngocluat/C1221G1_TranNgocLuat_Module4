package com.furama.repository;

import com.furama.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentServiceRepository extends JpaRepository<RentType, Long> {
}
