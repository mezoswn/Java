package com.codingdojoassignments.axsos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojoassignments.axsos.models.Dojo;
import com.codingdojoassignments.axsos.models.Ninja;
import com.codingdojoassignments.axsos.services.DojoNinjaService;

@Controller
public class MainController {
	
	private DojoNinjaService dojoninjaService;
	
	public MainController(DojoNinjaService dojoninjaService) {
		super();
		this.dojoninjaService=dojoninjaService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos",dojoninjaService.getAllDojos());
		return "index.jsp";
	}
	
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "createDojo.jsp";
	}
	
	@RequestMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("allDojos",dojoninjaService.getAllDojos());
		return "createNinja.jsp";
	}
	
	@RequestMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			this.dojoninjaService.createNinja(ninja);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			this.dojoninjaService.createDojo(dojo);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = this.dojoninjaService.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}

}
