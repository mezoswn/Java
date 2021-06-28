package com.codingdojoassignments.axsos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoassignments.axsos.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{
	List<City> findAll();
	@Query("SELECT ci FROM City ci JOIN ci.country c WHERE c.name = 'Mexico' AND c.population > 500000 ORDER BY c.population DESC")
	List<City> mexicanCities();
	@Query("SELECT c.name AS countryName, ci.name AS cityName, ci.district, ci.population FROM City ci JOIN ci.country c WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND c.population > 500000 ORDER BY ci.population DESC")
	List<Object[]> argentinaBuenosAires();
}
