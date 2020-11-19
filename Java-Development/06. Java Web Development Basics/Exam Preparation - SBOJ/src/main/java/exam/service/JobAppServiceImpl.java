package exam.service;

import exam.domain.entities.JobApplication;
import exam.domain.models.service.JobAppServiceModel;
import exam.repository.JobAppRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobAppServiceImpl implements JobAppService {
    private final JobAppRepository jobAppRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobAppServiceImpl(JobAppRepository jobAppRepository, ModelMapper modelMapper) {
        this.jobAppRepository = jobAppRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerJob(JobAppServiceModel jobAppServiceModel) {
        JobApplication jobApplication =
                this.modelMapper.map(jobAppServiceModel, JobApplication.class);

        this.jobAppRepository.save(jobApplication);
    }

    @Override
    public List<JobAppServiceModel> findAllJobs() {
        return this.jobAppRepository.findAll()
                .stream()
                .map(jobApplication -> this.modelMapper.map(jobApplication, JobAppServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobAppServiceModel findJobById(String id) {
        return this.modelMapper
                .map(this.jobAppRepository.findById(id), JobAppServiceModel.class);


    }

    @Override
    public void delete(String id) {
        this.jobAppRepository.delete(id);
    }
}
