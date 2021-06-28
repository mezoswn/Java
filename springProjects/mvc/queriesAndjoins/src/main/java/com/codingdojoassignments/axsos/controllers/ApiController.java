package com.codingdojoassignments.axsos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojoassignments.axsos.models.City;
import com.codingdojoassignments.axsos.models.Country;
import com.codingdojoassignments.axsos.models.Language;
import com.codingdojoassignments.axsos.services.WorldService;

@RestController
public class ApiController {
	@Autowired
	private WorldService wService;
	@GetMapping("/")
	public List<Country> Index() {
		return this.wService.getCountries();
	}
	@GetMapping("/n/{name}")
	public List<Object[]> CountryByName(@PathVariable("name") String name) {
		return this.wService.getCountryByLanguage(name);
	}
	@GetMapping("/n/cityCount")
	public List<Object[]> CountryByCityCount() {
		return this.wService.getCountriesByCityCount();
	}
	@GetMapping("/n/region")
	public List<Object[]> CountryByRegion() {
		return this.wService.getCountryByRegion();
	}
	@GetMapping("/c")
	public List<City> Cities() {
		return this.wService.getCities();
	}
	@GetMapping("/c/mexico")
	public List<City> MexicanCities() {
		return this.wService.getMexicanCities();
	}
	@GetMapping("/c/arg")
	public List<Object[]> BACities() {
		return this.wService.getBuenosAiresCities();
	}
	@GetMapping("/l")
	public List<Language> Languages() {
		return this.wService.getLanguages();
	}
	@GetMapping("/l/c")
	public List<Object[]> CountryLangs() {
		return this.wService.getCountryLanguagues();
	}

}
