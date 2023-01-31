package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Car;
import org.example.entity.Person;
import org.example.entity.SocialMedia;
import org.example.repasitory.CarRepasitory;
import org.example.repasitory.CarRepasitoryImpl;
import org.example.service.*;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
//        HibernateConfig.getEntityManager();
        Car car = new Car("Matiz","Deawo","UZB");
        Car car1 = new Car("BMW","BMW","Germany");
        Car car2 = new Car("Honda","Toyata","Yoponia");

        Person person = new Person("Syimyk",22);
        Person person2 = new Person("Osmon",18);
        Person person3 = new Person("Adilet",22);

        SocialMedia socialMedia = new SocialMedia("Instagram");
        SocialMedia socialMedia1 = new SocialMedia("Whatsapp");
        SocialMedia socialMedia2 = new SocialMedia("Facebook");

        PersonService personService = new PersonServiceImpl();
        CarRepasitory carRepasitory = new CarRepasitoryImpl();
        SocialService socialService = new SocialServiceImpl();
        Person person1 = new Person("Baytik",20,Arrays.asList(socialMedia1,socialMedia2),Arrays.asList(car1,car2));
    //~~~~~~~~~~~~~~~~~~PERSon!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        person1.setCars(Arrays.asList(car1,car2));
//        person1.setSocialMedia(Arrays.asList(socialMedia1,socialMedia2));
//        System.out.println(personService.save(person1));
//     2-   System.out.println(personService.getByid(1L));
        //3method
//        personService.getall().forEach(System.out::println);
        //4-method
//        System.out.println(personService.update(1L, new Person("Zhazgul", 20)));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~MEDIa!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        SocialMedia socialMedia3 = new SocialMedia("TElegram",Arrays.asList(person2,person3));
//        socialMedia3.setPeople(Arrays.asList(person2,person3));
//        socialService.save(socialMedia3);
        //2-method
//        System.out.println(socialService.getSocialMediaPersonName("Osmon"));
        //3-method
//        socialService.getAllSocialMediaSortByNameByDesc().forEach(System.out::println);
        //4-method
//        System.out.println(socialService.deleteById(3L));


        //!!!!!!!!!!!!!!!!!!!!!!!!CAr!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
          //1-method
//         Car car3 = new Car("jk","hjk","hjk",person);
//         car3.setPerson(person);
//        System.out.println(carRepasitory.save(car3));
///      2-method
//        System.out.println(carRepasitory.getCarByPersonId(1L));
        //3-method
//        carRepasitory.getAllCArs().forEach(System.out::println);
        //4-method
        System.out.println(carRepasitory.deleteByName("Honda"));

    }
}
