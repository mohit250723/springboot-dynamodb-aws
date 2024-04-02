package com.mohit.springbootdynamodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.mohit.springbootdynamodb.entity.Person;

@Repository
public class PersonRepository {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public Person addPerson(Person person) {
		mapper.save(person);
		return person;
	
	}
	
	public Person findByPersonId(String personId) {
		return mapper.load(Person.class, personId);
	}
	

}
