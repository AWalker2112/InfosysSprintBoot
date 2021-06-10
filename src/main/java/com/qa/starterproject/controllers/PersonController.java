package com.qa.starterproject.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.domain.Person;
import com.qa.starterproject.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonService service;

	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}

	// CRUD methods
	@PostMapping("/create")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		
		return new ResponseEntity<Person>(this.service.addPerson(person), HttpStatus.CREATED);
	}
	//GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAllPeople() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	//GET ONE
	@GetMapping("/getOne/{index}")
	public ResponseEntity<Person> getVehicle(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getPerson(id));
	}

	//PUT
	@PutMapping("/update")
	public ResponseEntity<Person> updatePerson(@PathParam("id") Long id, @RequestBody Person person) {
		this.service.updatePerson(id, person);
		return new ResponseEntity<Person>(person, HttpStatus.ACCEPTED);
	}
	

	//DELETE ONE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity removePerson(@PathVariable Long id) {
		return this.service.removePerson(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}

}
