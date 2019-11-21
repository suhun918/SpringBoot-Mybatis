package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.demo.model.Person;
import com.cos.demo.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository repository;

	// Get (select), Post(insert), Put(update), Delete

	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id) {
		Person person = repository.findById(id);
		return person;
	}

	// insert
	// person은 param, x-www-form-urlencoded 두 경우만 받고
	// json 데이터는 받지 못한다. json 을 받고싶으면 person 앞에 @ResponseBody 붙여줘야함
	@PostMapping("/person")
	public int setPerson(Person person) {
		try {
			repository.save(person);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@DeleteMapping("/person/{id}")
	public int deletePerson(@PathVariable int id) {
		try {
			repository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@PutMapping("/person")
	public int updatePerson(Person person) {
		try {
			repository.update(person);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

}
