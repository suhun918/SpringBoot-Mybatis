package com.cos.demo.repository;

import com.cos.demo.model.Person;

//파라메터는 무조건 하나만 받아야한다.!!!!!!!
public interface PersonRepository {
	Person findById(int id);
	void save(Person person);
	void delete(int id);
	void update(Person person);
}
