package com.codingdojoassignments.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoassignments.axsos.models.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long>{
	
	List<Driver> findAll();

}
