package com.relationships.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
//	private final PersonService personService;
	
	public LicenseService(LicenseRepository licenseRepo, PersonService personService) { 
		this.licenseRepo = licenseRepo; 
//		this.personService = personService;
	}
	

	// retrieve all license
	public List<License> allLicense(){
		return this.licenseRepo.findAll();
	}
	
	// create a new License
	public License createLicense(String expiration_date, String state, Person person) {
		// generate New license number
		String number = GenerateLicenseNumber(person.getId());
		License license = new License(number, expiration_date, state, person);
		return this.licenseRepo.save(license);
	}
	
	// generate New license number
	public String GenerateLicenseNumber(Long id) {
		String str = Long.toString(id);
		String zeroString = "0";
		
		while(str.length() < 5) {
			str = "0"+str;
			
//			str = zeroString.concat(str);
		}
		return str;
	}
}
