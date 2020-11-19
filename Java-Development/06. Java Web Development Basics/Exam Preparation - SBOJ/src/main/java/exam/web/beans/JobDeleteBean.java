package exam.web.beans;

import exam.domain.entities.JobApplication;
import exam.domain.models.service.JobAppServiceModel;
import exam.service.JobAppService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class JobDeleteBean {

    private JobAppService jobAppService;

    public JobDeleteBean() {
    }

    @Inject
    public JobDeleteBean(JobAppService jobAppService) {
        this.jobAppService = jobAppService;
    }

    public JobAppServiceModel getJobApplication(String id){
        return this.jobAppService.findJobById(id);
    }
    public void deleteJob() throws IOException {
        String id = ((HttpServletRequest)
                FacesContext.getCurrentInstance().getExternalContext().getRequest())
                .getParameter("id");
        this.jobAppService.delete(id);

        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/faces/view/home.xhtml");
    }
}
