package com.fusiontech.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fusiontech.dto.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Integer>{

	
}
