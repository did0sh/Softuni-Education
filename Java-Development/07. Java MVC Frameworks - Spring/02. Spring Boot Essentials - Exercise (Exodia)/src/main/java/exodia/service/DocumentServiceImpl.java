package exodia.service;

import exodia.domain.entities.Document;
import exodia.domain.models.service.DocumentServiceModel;
import exodia.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Document saveDocument(DocumentServiceModel documentServiceModel) {
        Document document = this.modelMapper.map(documentServiceModel, Document.class);
        try {
            this.documentRepository.saveAndFlush(document);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return document;
    }

    @Override
    public List<DocumentServiceModel> findAllDocuments() {
        return this.documentRepository.findAll()
                .stream()
                .map(document -> this.modelMapper.map(document, DocumentServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public DocumentServiceModel findDocumentById(String id) {
        Document document = this.documentRepository.findById(id)
                .orElse(null);

        if (document == null){
            return null;
        }

        return this.modelMapper
                .map(document, DocumentServiceModel.class);

    }

    @Override
    public boolean printDocument(String id) {
        try {
            this.documentRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
