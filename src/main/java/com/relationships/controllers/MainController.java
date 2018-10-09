package com.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.services.LicenseService;
import com.relationships.services.PersonService;

@Controller
public class MainController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public MainController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/persons/new")
	public String newPersonForm(@ModelAttribute("person") Person person) {
		return "person/new.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "person/new.jsp";
		}
		else {
			this.personService.createPerson(person);
		}
		return "redirect:/licenses/new";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicenseForm(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = this.personService.allPersons();
		model.addAttribute("persons", persons);
		return "license/licenseForm.jsp";
	}
	
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license/licenseForm.jsp";
		}
		else {
			this.licenseService.createLicense(license.getExpiration_date(), license.getState(), license.getPerson());
		}
		return "redirect:/persons/"+license.getPerson().getId();
	}
	
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = this.personService.findPersonById(id);
		model.addAttribute("person", person);
		return "show.jsp";
	}
	

}
