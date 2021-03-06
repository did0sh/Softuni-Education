package exam.repository;

import exam.domain.entities.Document;

public interface DocumentRepository extends GenericRepository<Document, String> {

    Document findByTitle(String title);

    void print(String id);
}
