package exam.repository;

import exam.domain.entities.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JobAppRepositoryImpl implements JobAppRepository {
    private final EntityManager entityManager;

    @Inject
    public JobAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public JobApplication save(JobApplication jobApplication) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(jobApplication);
        this.entityManager.getTransaction().commit();
        return jobApplication;
    }

    @Override
    public List<JobApplication> findAll() {
        List<JobApplication> jobApplications = this.entityManager
                .createQuery("SELECT j FROM job_applications j", JobApplication.class)
                .getResultList();
        return jobApplications;
    }

    @Override
    public JobApplication findById(String id) {
        JobApplication jobApplication = this.entityManager
                .createQuery("SELECT j FROM job_applications j WHERE j.id =: id", JobApplication.class)
                .setParameter("id", id)
                .getSingleResult();
        return jobApplication;
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        Query query = this.entityManager.createQuery("DELETE FROM job_applications j WHERE j.id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
