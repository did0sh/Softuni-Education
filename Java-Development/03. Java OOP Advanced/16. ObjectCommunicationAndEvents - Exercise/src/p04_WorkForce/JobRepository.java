package p04_WorkForce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobRepository {
    private List<Job> jobs;

    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public void status(){
        this.jobs = this.jobs.stream().filter(job -> job.getHoursOfWorkRequired() > 0)
                .collect(Collectors.toList());
        this.jobs.forEach(System.out::print);
    }

    public void pass(){
        this.jobs.forEach(Job::update);
        this.jobs = this.jobs.stream().filter(job -> job.getHoursOfWorkRequired() > 0)
                .collect(Collectors.toList());
    }
}
