package com.qa.starterproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;

import com.qa.starterproject.domain.Person;

@Service
public class PersonService {

	private List<Person> people = new ArrayList<>();

	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}

	public Person addPerson(Person person) {

		// Add new Person
		this.people.add(person);
		// Return last added Person from List
		return this.people.get(this.people.size() - 1);
	}

	// READ ALL

	public List<Person> getAll() {
		return this.people;
	}

	// UPDATE
	public Person updatePerson(int id, Person person) {
		// Remove existing Person with matching 'id'
		this.people.remove(id);
		// Add new Person in its place
		this.people.add(id, person);
		// Return updated Person from List
		return this.people.get(id);
	}

	// DELETE
	public Person removePerson(int id) {
		// Remove Person and return it
		return this.people.remove(id);
	}
}
