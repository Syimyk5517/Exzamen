package org.example.service;

import org.example.entity.Person;
import org.example.repasitory.PersonRepasitory;
import org.example.repasitory.PersonRepasitoryImpl;

import java.util.List;

public class PersonServiceImpl implements PersonService{
    PersonRepasitory personRepasitory = new PersonRepasitoryImpl();
    @Override
    public String save(Person person) {
        personRepasitory.save(person);
        return "!!!";
    }

    @Override
    public Person getByid(Long id) {
        return personRepasitory.getByid(id);
    }

    @Override
    public List<Person> getall() {
        return personRepasitory.getall();
    }

    @Override
    public String deleteById(Long id) {
        personRepasitory.deleteById(id);
        return "!!";
    }

    @Override
    public String update(Long id, Person person) {
        personRepasitory.update(id,person);
        return "!!!";
    }
}
