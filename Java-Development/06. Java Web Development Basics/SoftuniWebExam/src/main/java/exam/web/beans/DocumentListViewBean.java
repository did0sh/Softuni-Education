package exam.web.beans;

import exam.domain.models.view.DocumentListViewModel;
import exam.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class DocumentListViewBean {

    private List<DocumentListViewModel> documentListViewModels;
    private DocumentService documentService;
    private ModelMapper modelMapper;

    public DocumentListViewBean() {
    }

    @Inject
    public DocumentListViewBean(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {
        this.documentListViewModels = this.documentService
                .getAllDocuments()
                .stream()
                .map(d -> this.modelMapper.map(d, DocumentListViewModel.class))
                .collect(Collectors.toList());
    }

    public List<DocumentListViewModel> getDocumentListViewModels() {
        return this.documentListViewModels;
    }

    public void setDocumentListViewModels(List<DocumentListViewModel> documentListViewModels) {
        this.documentListViewModels = documentListViewModels;
    }
}
