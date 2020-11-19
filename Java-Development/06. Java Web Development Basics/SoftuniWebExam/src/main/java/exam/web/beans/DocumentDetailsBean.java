package exam.web.beans;

import exam.domain.models.service.DocumentServiceModel;
import exam.domain.models.view.DocumentDetailsViewModel;
import exam.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class DocumentDetailsBean {

    private DocumentService documentService;

    public DocumentDetailsBean() {
    }

    @Inject
    public DocumentDetailsBean(DocumentService documentService) {
        this.documentService = documentService;
    }


    public DocumentServiceModel findDocument(String id){
       DocumentServiceModel model = this.documentService.findDocumentById(id);
       return model;
    }

}
