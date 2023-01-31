package org.example.repasitory;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Car;
import org.example.entity.Person;
import org.example.entity.SocialMedia;

import java.util.List;

public class CarRepasitoryImpl implements CarRepasitory,AutoCloseable{
   private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String save(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!";
    }

    @Override
    public Car getCarByPersonId(Long id) {
        entityManager.getTransaction().begin();
      Car car =  entityManager.createQuery("select c from Car c join Person p on  p.id = c.id", Car.class).getResultStream().filter(p->p.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return car;
    }

    @Override
    public List<Car> getAllCArs() {
          entityManager.getTransaction().begin();
         List<Car> carList = entityManager.createQuery("select c from Car c", Car.class).getResultList();
          entityManager.getTransaction().commit();
          entityManager.close();
        return carList;
    }

    @Override
    public String update(Long id, Car car) {
        entityManager.getTransaction().begin();
        Car oldCar = entityManager.find(Car.class,id);
        oldCar.setId(car.getId());
        oldCar.setName(car.getName());
        oldCar.setModel(car.getModel());
        oldCar.setCountry(car.getCountry());
        oldCar.setPerson(car.getPerson());
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public String deleteByName(String name) {
        entityManager.getTransaction().begin();
        Car car = entityManager.createQuery("select c FROM Car c where c.name=name", Car.class).getSingleResult();
        car.getPerson().setCars(null);
        entityManager.remove(car);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!!";
    }
//    SocialMedia socialMedia = entityManager.find(SocialMedia.class,id);
//        for (Person person : socialMedia.getPeople()) {
//        person.setSocialMedia(null);}

    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
