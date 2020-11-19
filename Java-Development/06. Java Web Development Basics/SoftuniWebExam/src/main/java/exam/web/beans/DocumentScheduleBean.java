package exam.web.beans;

import exam.domain.models.binding.DocumentScheduleBindingModel;
import exam.domain.models.service.DocumentServiceModel;
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
public class DocumentScheduleBean {

    private DocumentScheduleBindingModel documentScheduleBindingModel;
    private DocumentService documentService;
    private ModelMapper modelMapper;

    public DocumentScheduleBean() {
    }

    @Inject
    public DocumentScheduleBean(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
        this.documentScheduleBindingModel = new DocumentScheduleBindingModel();
    }

    public DocumentScheduleBindingModel getDocumentScheduleBindingModel() {
        return this.documentScheduleBindingModel;
    }

    public void setDocumentScheduleBindingModel(DocumentScheduleBindingModel documentScheduleBindingModel) {
        this.documentScheduleBindingModel = documentScheduleBindingModel;
    }

    public void schedule() throws IOException {
        DocumentServiceModel model = this.modelMapper.map(this.documentScheduleBindingModel, DocumentServiceModel.class);

        if (!this.documentService.scheduleDocument(model)) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        DocumentServiceModel documentByTitle = this.documentService.findDocumentByTitle(
                model.getTitle()
        );

        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .redirect("/faces/view/details.xhtml?id="+documentByTitle.getId());
    }
}
