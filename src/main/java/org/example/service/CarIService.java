package org.example.service;

import org.example.entity.Car;

import java.util.List;

public interface CarIService {
    String save(Car car);
    Car getByid(Long id);
    List<Car> getall();
    String deleteById(Long id);
    String update(Long id,Car car);
}
