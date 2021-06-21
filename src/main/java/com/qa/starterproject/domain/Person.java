package com.qa.starterproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // <- Type of id
	
	private String name;
	private String gender;
	private int age;
	
	
	
	
	//getters and setters
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	//constructor
	
	
	public Person() {
		super();
	}
	
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Person(Long id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	
	
	
	
}
