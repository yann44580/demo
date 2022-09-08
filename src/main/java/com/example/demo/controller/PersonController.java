package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;


	@GetMapping("/")
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable long id) throws Exception {
		return this.personRepository.findById(id).orElseThrow(() -> new Exception("La personne n'existe pas"));
	}

	@PostMapping("/")
	public Person savePerson(@RequestBody Person person) {
		return this.personRepository.save(person);
	}

	@PutMapping("/")
	Person updatePerson(@RequestBody Person person, @PathVariable long id) {
		return this.personRepository.findById(id).map(x -> {
			x.setName(person.getName());
			x.setFullname(person.getFullname());
			return personRepository.save(x);
		}).orElseGet(() -> {
			person.setId(id);
			return personRepository.save(person);
		});
	}

	@DeleteMapping("/{id}")
	 void deleteById(@PathVariable Long id) { 
		this.personRepository.deleteById(id); }
	 
}
