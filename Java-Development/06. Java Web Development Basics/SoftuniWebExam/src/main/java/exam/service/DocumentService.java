package exam.service;

import exam.domain.models.service.DocumentServiceModel;

import java.util.List;

public interface DocumentService {

    boolean scheduleDocument(DocumentServiceModel documentServiceModel);

    DocumentServiceModel getDocumentById(String id);

    List<DocumentServiceModel> getAllDocuments();

    DocumentServiceModel findDocumentById(String id);

    DocumentServiceModel findDocumentByTitle(String title);

    boolean print(String id);
}
