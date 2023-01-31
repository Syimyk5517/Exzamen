package org.example.repasitory;

import org.example.entity.Car;
import org.example.entity.Person;

import java.util.List;

public interface PersonRepasitory {
    String save(Person person);
    Person getByid(Long id);
    List<Person> getall();
    String deleteById(Long id);
    String update(Long id,Person person);
}
