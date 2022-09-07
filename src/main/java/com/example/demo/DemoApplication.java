package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		Person p = new Person();
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabaseH2(PersonRepository personRepository) {
		return args->{
			personRepository.save(new Person(Long.parseLong("1") , "yann" , "fiolleau"));
			personRepository.save(new Person(Long.parseLong("2") , "sylvain" , "fiolleau"));
			personRepository.save(new Person(Long.parseLong("3") , "jerome" , "fiolleau"));
		};
	}
}
