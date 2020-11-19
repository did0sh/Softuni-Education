package panda.repository;

import panda.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<User> findAll() {
        List<User> users = this.entityManager
                .createQuery("SELECT u FROM users u", User.class)
                .getResultList();
        return users;
    }

    @Override
    public User findById(String id) {
        User user = this.entityManager
                .createQuery("SELECT u FROM users u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        return user;
    }

    @Override
    public Long size() {
        Long size = this.entityManager
                .createQuery("SELECT count(u) FROM users u ", Long.class)
                .getSingleResult();
        return size;
    }


    @Override
    public User findByUsername(String username) {
        try {
            User user = this.entityManager
                    .createQuery("SELECT u FROM users u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return user;

        }catch (Exception e){
            return null;
        }
    }
}
