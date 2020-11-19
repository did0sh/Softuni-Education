package exam.web.beans;

import exam.domain.models.binding.JobAppRegisterBindingModel;
import exam.domain.models.binding.JobListBindingModel;
import exam.service.JobAppService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class JobListBean implements Serializable {

    private JobAppService jobAppService;
    private ModelMapper modelMapper;
    private JobListBindingModel jobListBindingModel;

    public JobListBean() {
    }

    @Inject
    public JobListBean(JobAppService jobAppService, ModelMapper modelMapper) {
        this.jobAppService = jobAppService;
        this.modelMapper = modelMapper;
        this.jobListBindingModel = new JobListBindingModel();
        this.jobListBindingModel.setJobs(
                this.jobAppService.findAllJobs()
                    .stream().map(jobAppServiceModel -> this.modelMapper.map(jobAppServiceModel, JobAppRegisterBindingModel.class))
                .collect(Collectors.toList())
        );
    }

    public JobListBindingModel getJobListBindingModel() {
        return this.jobListBindingModel;
    }

    public void setJobListBindingModel(JobListBindingModel jobListBindingModel) {
        this.jobListBindingModel = jobListBindingModel;
    }
}
