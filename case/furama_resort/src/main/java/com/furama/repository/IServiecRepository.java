package com.furama.repository;

import com.furama.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiecRepository extends JpaRepository<Service , Long> {
}
