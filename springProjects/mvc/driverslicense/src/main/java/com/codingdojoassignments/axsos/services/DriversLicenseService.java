package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Driver;
import com.codingdojoassignments.axsos.models.License;
import com.codingdojoassignments.axsos.repositories.DriverRepository;
import com.codingdojoassignments.axsos.repositories.LicenseRepository;

@Service
public class DriversLicenseService {
	
	private DriverRepository driverRepository;
	private LicenseRepository licenseRepository;
	
	public DriversLicenseService(DriverRepository driverRepository, LicenseRepository licenseRepository) {
		this.driverRepository = driverRepository;
		this.licenseRepository = licenseRepository;
}
	
	public Driver createDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public List<Driver> getAllPeople(){
		return driverRepository.findAll();
	}
	
	public List<License> getAllLicenses(){
		return licenseRepository.findAll();
	}
	
	public Driver getDriver(Long id) {
		Optional<Driver> optionalDriver = this.driverRepository.findById(id);
		if (optionalDriver.isPresent()) {
			return optionalDriver.get();
		}
		return null;
	}

}
