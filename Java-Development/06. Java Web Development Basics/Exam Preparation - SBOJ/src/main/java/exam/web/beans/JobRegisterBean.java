package exam.web.beans;

import exam.domain.models.binding.JobAppRegisterBindingModel;
import exam.domain.models.service.JobAppServiceModel;
import exam.repository.JobAppRepository;
import exam.service.JobAppService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class JobRegisterBean implements Serializable {

    private JobAppService jobAppService;
    private ModelMapper modelMapper;
    private JobAppRegisterBindingModel jobAppRegisterBindingModel;

    public JobRegisterBean() {
    }

    @Inject
    public JobRegisterBean(JobAppService jobAppService, ModelMapper modelMapper) {
        this.jobAppService = jobAppService;
        this.modelMapper = modelMapper;
        this.jobAppRegisterBindingModel = new JobAppRegisterBindingModel();
    }

    public JobAppRegisterBindingModel getJobAppRegisterBindingModel() {
        return this.jobAppRegisterBindingModel;
    }

    public void setJobAppRegisterBindingModel(JobAppRegisterBindingModel jobAppRegisterBindingModel) {
        this.jobAppRegisterBindingModel = jobAppRegisterBindingModel;
    }

    public void register() throws IOException {
        JobAppServiceModel jobAppServiceModel =
                this.modelMapper.map(jobAppRegisterBindingModel, JobAppServiceModel.class);

        this.jobAppService.registerJob(jobAppServiceModel);

        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/faces/view/home.xhtml");
    }
}
