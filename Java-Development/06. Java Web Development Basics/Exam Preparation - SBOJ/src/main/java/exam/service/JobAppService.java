package exam.service;

import exam.domain.models.service.JobAppServiceModel;

import java.util.List;

public interface JobAppService {

    void registerJob(JobAppServiceModel jobAppServiceModel);

    List<JobAppServiceModel> findAllJobs();

    JobAppServiceModel findJobById(String id);

    void delete(String id);
}
