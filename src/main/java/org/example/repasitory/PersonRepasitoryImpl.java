package org.example.repasitory;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Car;
import org.example.entity.Person;

import java.util.List;

public class PersonRepasitoryImpl implements PersonRepasitory,AutoCloseable{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!!";
    }

    @Override
    public Person getByid(Long id) {
        entityManager.getTransaction().begin();
       Person person1 = entityManager.createQuery("select p from Person p", Person.class).getResultStream().filter(p->p.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return person1;
    }

    @Override
    public List<Person> getall() {
        entityManager.getTransaction().begin();
        List<Person> personList = entityManager.createQuery("select p from Person p", Person.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return personList;
    }

    @Override
    public String deleteById(Long id) {
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class,id);
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public String update(Long id, Person person) {
        entityManager.getTransaction().begin();
        Person oldPerson = entityManager.find(Person.class,id);
        oldPerson.setName(person.getName());
        oldPerson.setAge(person.getAge());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!!";
    }
    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
