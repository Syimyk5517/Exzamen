package org.example.repasitory;

import org.example.entity.Car;

import java.util.List;

public interface CarRepasitory {
    String save(Car car);
    Car getCarByPersonId(Long id);
    List<Car> getAllCArs();
    String update(Long id , Car car);
    String deleteByName(String name);

}
