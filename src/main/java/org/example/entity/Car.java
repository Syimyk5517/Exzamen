package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "people" )
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model ;
    private String country;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Person person;

    public Car( String name, String model, String country) {
        this.name = name;
        this.model = model;
        this.country = country;
    }

    public Car(String name, String model, String country, Person person) {
        this.name = name;
        this.model = model;
        this.country = country;
        this.person = person;
    }
}
