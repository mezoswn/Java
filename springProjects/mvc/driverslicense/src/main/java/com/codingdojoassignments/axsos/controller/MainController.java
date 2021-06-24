package com.codingdojoassignments.axsos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojoassignments.axsos.models.Driver;
import com.codingdojoassignments.axsos.models.License;
import com.codingdojoassignments.axsos.services.DriversLicenseService;

@Controller
public class MainController {
	
	private final DriversLicenseService driverslicenseService;
	
	public MainController (DriversLicenseService driverslicenseService) {
		this.driverslicenseService = driverslicenseService;
	}
	
	@RequestMapping("/")
	public String index (Model model) {
		model.addAttribute("driver", driverslicenseService.getAllPeople());
		model.addAttribute("licenses", driverslicenseService.getAllLicenses());
		return "index.jsp";
	}
	
	@RequestMapping("/drivers/new")
	public String newDriver (@ModelAttribute("driver") Driver driver) {
		return "create.jsp";
	}
	
	@RequestMapping(value = "/drivers/create", method = RequestMethod.POST)
	public String createDriver(@Valid @ModelAttribute("driver") Driver driver,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			this.driverslicenseService.createDriver(driver);
			return "redirect:/";
		}		
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("people", driverslicenseService.getAllPeople());
		return "license.jsp";
	}
	
	@RequestMapping(value = "/licenses/create", method = RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "license.jsp";
		} else {
			this.driverslicenseService.createLicense(license);
			return "redirect:/";
		}		
	}
	
	@RequestMapping(value = "/drivers/{id}")
	public String showDriver(@PathVariable("id")Long id, Model model) {
		Driver driver = this.driverslicenseService.getDriver(id);
		model.addAttribute("driver", driver);
		return "show.jsp";
		
	}
	

}
