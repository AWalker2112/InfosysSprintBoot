package com.qa.starterproject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.starterproject.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	

}