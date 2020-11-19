package metubev2.repository;

import metubev2.domain.entities.User;

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
    public User findById(String s) {
        User user = this.entityManager
                .createQuery("SELECT u FROM users u WHERE u.id = :id", User.class)
                .setParameter("id", s)
                .getSingleResult();

        return user;
    }

    @Override
    public long size() {
        long size = this.entityManager
                .createQuery("SELECT count(u) FROM users u", long.class)
                .getSingleResult();

        return size;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {

        User user;
        try {
             user = this.entityManager
                    .createQuery("SELECT u FROM users u WHERE u.username = :username AND u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch (Exception ex){
            return null;
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {

        User user;
        try {
            this.entityManager.clear();
            user = this.entityManager
                    .createQuery("SELECT u FROM users u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        }catch (Exception ex){
            return null;
        }

        return user;
    }
}
