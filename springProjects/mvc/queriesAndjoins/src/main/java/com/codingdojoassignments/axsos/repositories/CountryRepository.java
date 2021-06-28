package com.codingdojoassignments.axsos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoassignments.axsos.models.Country;
@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	List<Country> findAll();
	@Query("SELECT c FROM Country c WHERE name LIKE %?1%")
	List<Country> findCountryByName(String name);
	@Query("SELECT c.name, l.language, l.percentage FROM Country c INNER JOIN c.languages l WHERE l.language LIKE %?1% ORDER BY l.percentage DESC")
	List<Object[]> findCountryByLang(String lang);
	@Query("SELECT c.name, COUNT(ci.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY num_cities DESC")
	List<Object[]> findCountryCityCount();
	@Query("SELECT c FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000 ORDER BY c.population DESC")
	List<Country> findDenseCountries();
	@Query("SELECT c FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.lifeExpectancy > 75 AND c.capital > 200")
	List<Country> findConMonCountries();
	@Query("SELECT c.region, COUNT(c.id) AS num_countries FROM Country c GROUP BY c.region ORDER BY num_countries DESC")
	List<Object[]> findCountryByRegion();
}
