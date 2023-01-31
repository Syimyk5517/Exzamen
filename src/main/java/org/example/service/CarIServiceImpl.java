package org.example.service;

import jakarta.persistence.CascadeType;
import org.example.entity.Car;
import org.example.repasitory.CarRepasitory;
import org.example.repasitory.CarRepasitoryImpl;

import java.util.List;

public class CarIServiceImpl implements CarRepasitory {
    CarRepasitory carRepasitory = new CarRepasitoryImpl();
    @Override
    public String save(Car car) {
        carRepasitory.save(car);

        return "!!!!";
    }

    @Override
    public Car getCarByPersonId(Long id) {
        return carRepasitory.getCarByPersonId(id);
    }

    @Override
    public List<Car> getAllCArs() {
        return carRepasitory.getAllCArs();
    }

    @Override
    public String update(Long id, Car car) {
        carRepasitory.update(id,car);
        return "!!!";
    }

    @Override
    public String deleteByName(String name) {
        carRepasitory.deleteByName(name);
        return "!!!";
    }
}
