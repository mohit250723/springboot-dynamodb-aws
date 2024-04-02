package com.mohit.springbootdynamodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springbootdynamodb.entity.Person;
import com.mohit.springbootdynamodb.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person) {
		return repository.addPerson(person);
	}
	
	@GetMapping("/findPerson/{personId}")
	public Person getPersonById(@PathVariable String personId) {
		return repository.findByPersonId(personId);
	}

}
