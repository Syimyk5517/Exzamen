package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "people")
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private String name;
    @ManyToMany(cascade =  {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Person> people;

    public SocialMedia( String name) {
        this.name = name;
    }

    public SocialMedia(String name, List<Person> people) {
        this.name = name;
        this.people = people;
    }
}
