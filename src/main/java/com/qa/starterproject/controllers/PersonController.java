package com.qa.starterproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.domain.Person;

@RestController
public class PersonController {
	@GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }
	
	
	private List<Person> people = new ArrayList<>();
	
	@PostMapping("/create")
    public String addPerson(@RequestBody Person person) {
        this.people.add(person);
        return "Added Person";
    }
	@GetMapping("/getAll")
    public List<Person> getAll() {
        return this.people;
    }
	
}
