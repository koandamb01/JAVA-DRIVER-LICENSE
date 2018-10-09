package com.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.models.Person;
import com.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository PersonRepo;

	public PersonService(PersonRepository PersonRepo) { this.PersonRepo = PersonRepo; }
	
	// retrieve all persons
	public List<Person> allPersons(){ return this.PersonRepo.findAll(); }
	
	
	// retrieve a person
	public Person findPersonById(Long id) {
		Optional<Person> optionalPerson = PersonRepo.findById(id);
        
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
	}
	
	// create a new person
	public Person createPerson(Person person) {
		return this.PersonRepo.save(person);
	}
}
