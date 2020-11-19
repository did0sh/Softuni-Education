package metubev2.repository;

import metubev2.domain.entities.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class TubeRepositoryImpl implements TubeRepository {
    private final EntityManager entityManager;

    @Inject
    public TubeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Tube save(Tube entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        this.entityManager.flush();
        return entity;
    }

    @Override
    public List<Tube> findAll() {
        List<Tube> tubes = this.entityManager
                .createQuery("SELECT t FROM tubes t", Tube.class)
                .getResultList();

        return tubes;
    }

    @Override
    public Tube findById(String s) {
        Tube tube = this.entityManager
                .createQuery("SELECT t FROM tubes t WHERE t.id = :id", Tube.class)
                .setParameter("id", s)
                .getSingleResult();

        return tube;
    }

    @Override
    public long size() {
        long size = this.entityManager
                .createQuery("SELECT count(t) FROM tubes t", long.class)
                .getSingleResult();

        return size;
    }

    @Override
    public Tube update(Tube tube) {
        this.entityManager.merge(tube);
        return tube;
    }
}
