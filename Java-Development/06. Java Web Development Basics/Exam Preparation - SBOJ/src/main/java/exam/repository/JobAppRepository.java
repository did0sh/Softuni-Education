package exam.repository;

import exam.domain.entities.JobApplication;

public interface JobAppRepository extends GenericRepository<JobApplication, String> {

    void delete(String id);
}
