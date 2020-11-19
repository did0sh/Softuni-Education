package exam.repository;

import exam.domain.entities.Document;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("Duplicates")
public class DocumentRepositoryImpl implements DocumentRepository {

    private final EntityManager entityManager;

    @Inject
    public DocumentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Document save(Document document) {
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(document);
            this.entityManager.getTransaction().commit();

            return document;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();

            return null;
        }
    }

    @Override
    public List<Document> findAll() {
        this.entityManager.getTransaction().begin();
        List<Document> documents = this.entityManager
                .createQuery("SELECT d FROM documents d ", Document.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return documents;
    }

    @Override
    public Document findById(String id) {
        this.entityManager.getTransaction().begin();
        try {
            Document document = this.entityManager
                    .createQuery("SELECT d FROM documents d WHERE d.id = :id", Document.class)
                    .setParameter("id", id)
                    .getSingleResult();

            this.entityManager.getTransaction().commit();
            return document;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Document findByTitle(String title) {
        this.entityManager.getTransaction().begin();
        try {
            Document document = this.entityManager
                    .createQuery("SELECT d FROM documents d WHERE d.title = :title", Document.class)
                    .setParameter("title", title)
                    .getSingleResult();

            this.entityManager.getTransaction().commit();
            return document;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void print(String id) {
        this.entityManager.getTransaction().begin();
        Query query = this.entityManager.createQuery("DELETE FROM documents d WHERE d.id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
