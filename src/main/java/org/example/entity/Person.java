package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString(exclude = "socialmedia")
@Entity
@NoArgsConstructor
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private  int age;
    @ManyToMany(mappedBy = "people",cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH} )
    private List<SocialMedia> socialMedia;
    @OneToMany(mappedBy = "person",cascade =  {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Car> cars;

    public Person( String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, List<SocialMedia> socialMedia, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.socialMedia = socialMedia;
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
