package org.example.repasitory;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Person;
import org.example.entity.SocialMedia;

import java.util.List;

public class SocialMediaRepasitoryImpl implements SocialMediaRepasitory,AutoCloseable {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String save(SocialMedia socialMedia) {
        entityManager.getTransaction().begin();
        entityManager.merge(socialMedia);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!";
    }

    @Override
    public SocialMedia getSocialMediaPersonName(String name) {
        entityManager.getTransaction().begin();
      SocialMedia socialMedia = entityManager.createQuery("select s from SocialMedia s JOIN Person p", SocialMedia.class).getResultStream().filter(p->p.getName().equalsIgnoreCase(name)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return socialMedia;
    }

    @Override
    public String deleteById(Long id) {
        entityManager.getTransaction().begin();
        SocialMedia socialMedia = entityManager.find(SocialMedia.class,id);
        for (Person person : socialMedia.getPeople()) {
            person.setSocialMedia(null);}
        entityManager.remove(socialMedia);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!!";
    }

    @Override
    public List<SocialMedia> getAllSocialMediaSortByNameByDesc() {
        entityManager.getTransaction().begin();
        List<SocialMedia> socialMedia =  entityManager.createQuery("select s from SocialMedia s order by s.name desc ", SocialMedia.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return socialMedia;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
