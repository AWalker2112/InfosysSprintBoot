package com.qa.starterproject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.domain.Person;

@RestController
public class PersonController {
	
	private List<Person> people = new ArrayList<>();
	
	@GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }
	
	
	
	
	@PostMapping("/create")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		
        this.people.add(person);
        Person added = this.people.get(this.people.size()-1);
        return new ResponseEntity<Person>(added, HttpStatus.CREATED); 
    }
	@GetMapping("/getAll")
    public List<Person> getAll() {
        return this.people;
    }
	
	@PutMapping("/update")
    public Person updatePerson(@PathParam("id") int id, @RequestBody Person person) {
        // Remove existing Person with matching 'id'
        this.people.remove(id);
        // Add new Person in its place
        this.people.add(id, person);
        // Return updated Person from List
        return this.people.get(id);
    }
	
	 @DeleteMapping("/delete/{id}")
	    public Person removePerson(@PathVariable int id) {
	        // Remove Person and return it
	        return this.people.remove(id);
	    }
	
}
