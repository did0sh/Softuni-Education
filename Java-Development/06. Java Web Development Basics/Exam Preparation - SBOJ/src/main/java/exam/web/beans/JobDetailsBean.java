package exam.web.beans;

import exam.domain.models.service.JobAppServiceModel;
import exam.service.JobAppService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class JobDetailsBean {

    private JobAppService jobAppService;

    public JobDetailsBean() {
    }

    @Inject
    public JobDetailsBean(JobAppService jobAppService) {
        this.jobAppService = jobAppService;
    }

    public JobAppServiceModel findJob(String id){
        return this.jobAppService.findJobById(id);
    }
}
