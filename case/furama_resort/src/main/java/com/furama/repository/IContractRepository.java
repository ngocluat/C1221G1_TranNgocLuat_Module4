package com.furama.repository;

import com.furama.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract , Long> {
}
