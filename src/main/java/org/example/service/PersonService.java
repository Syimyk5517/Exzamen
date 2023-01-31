package org.example.service;

import org.example.entity.Person;

import java.util.List;

public interface PersonService {
    String save(Person person);
    Person getByid(Long id);
    List<Person> getall();
    String deleteById(Long id);
    String update(Long id,Person person);
}
