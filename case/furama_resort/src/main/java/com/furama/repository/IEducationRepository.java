package com.furama.repository;

import com.furama.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository  extends JpaRepository<EducationDegree , Long> {

}
