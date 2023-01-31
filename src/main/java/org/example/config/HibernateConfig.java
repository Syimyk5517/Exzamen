package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.entity.Car;
import org.example.entity.Person;
import org.example.entity.SocialMedia;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateConfig {

    public static EntityManager getEntityManager(){
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        configuration.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(Environment.USER, "postgres");
        configuration.setProperty(Environment.PASS, "syimyk");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(SocialMedia.class);
        configuration.addAnnotatedClass(Car.class);
        return configuration.buildSessionFactory().createEntityManager();

    }

}
