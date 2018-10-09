package com.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.repositories.LicenseRepository;
import com.relationships.repositories.PersonRepository;

@Service
public class MainService {
	private final PersonRepository PersonRepo;
	private final LicenseRepository LicenseRepo;
	
	public MainService(PersonRepository PersonRepo, LicenseRepository LicenseRepo) {
		this.PersonRepo = PersonRepo;
		this.LicenseRepo = LicenseRepo;
	}
	
	// retrieve all persons
	public List<Person> allPersons(){
		return this.PersonRepo.findAll();
	}
	
	// retrieve all license
	public List<License> allLicense(){
		return this.LicenseRepo.findAll();
	}
	
	// create a new person
	public Person createPerson(String firstName, String lastName) {
		Person person = new Person(firstName, lastName);
		return this.PersonRepo.save(person);
	}
}
