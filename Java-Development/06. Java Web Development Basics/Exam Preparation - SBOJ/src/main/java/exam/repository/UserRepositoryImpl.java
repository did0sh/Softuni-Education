package exam.repository;

import exam.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = this.entityManager.createQuery("SELECT u FROM users u", User.class)
                .getResultList();
        return users;
    }

    @Override
    public User findById(String id) {
        User user = this.entityManager.createQuery("SELECT u FROM users u WHERE u.id =: id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        return user;
    }

    @Override
    public User findByUsername(String username) {

        try {
            User user = this.entityManager.createQuery("SELECT u FROM users u WHERE u.username =: username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return user;
        }catch (Exception e){
            return null;
        }

    }
}
