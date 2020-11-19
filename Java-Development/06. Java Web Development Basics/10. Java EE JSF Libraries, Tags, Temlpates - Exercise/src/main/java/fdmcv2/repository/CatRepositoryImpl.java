package fdmcv2.repository;

import fdmcv2.domain.entities.Cat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class CatRepositoryImpl implements CatRepository {
    private final EntityManager entityManager;

    @Inject
    public CatRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cat save(Cat entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Cat> findAll() {
        List<Cat> cats = this.entityManager
                .createQuery("SELECT c FROM cats c", Cat.class)
                .getResultList();
        return cats;
    }

    @Override
    public Cat findById(String id) {
        Cat cat = this.entityManager
                .createQuery("SELECT c FROM cats c WHERE c.id = :id", Cat.class)
                .setParameter("id", id)
                .getSingleResult();
        return cat;
    }
}
