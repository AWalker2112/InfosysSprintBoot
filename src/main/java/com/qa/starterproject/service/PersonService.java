package com.qa.starterproject.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.qa.starterproject.domain.Person;
import com.qa.starterproject.repo.PersonRepo;

@Service
public class PersonService {

	private PersonRepo repo;
	
	
	
	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	//CRUD
	
	//CREATE
	
	public Person addPerson(Person person) {

		return this.repo.save(person);
	}

	// READ ALL

	public List<Person> getAll() {
		return this.repo.findAll();
	}

	//READ ONE
	public Person getPerson(Long id) {
		Optional<Person> p = this.repo.findById(id);
		return p.get();
	}
	
	
	// UPDATE
	public Person updatePerson(Long id, Person person) {
		Optional<Person> toBeUpdated = this.repo.findById(id);
		toBeUpdated = Optional.of(person); 
		return person; 
	}

	// DELETE
	public boolean removePerson(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}
