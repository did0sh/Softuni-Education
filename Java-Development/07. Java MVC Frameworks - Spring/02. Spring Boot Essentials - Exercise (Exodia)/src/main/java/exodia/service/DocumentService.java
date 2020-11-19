package exodia.service;

import exodia.domain.entities.Document;
import exodia.domain.models.service.DocumentServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {

    Document saveDocument(DocumentServiceModel documentServiceModel);

    List<DocumentServiceModel> findAllDocuments();

    DocumentServiceModel findDocumentById(String id);

    boolean printDocument(String id);
}
