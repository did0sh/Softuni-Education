package exam.domain.models.binding;

import java.util.List;

public class JobListBindingModel {

    private List<JobAppRegisterBindingModel> jobs;

    public JobListBindingModel() {
    }

    public List<JobAppRegisterBindingModel> getJobs() {
        return this.jobs;
    }

    public void setJobs(List<JobAppRegisterBindingModel> jobs) {
        this.jobs = jobs;
    }
}
