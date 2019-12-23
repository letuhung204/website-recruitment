package com.corlogy.service;

import com.corlogy.model.Job;

import java.util.List;

public interface JobService {
    //get list job
    List<Job> listAllJob();
    //get detail job by ID
    Job getJobById(int idJob);
    //save job
    Job saveJob(Job job);
    Boolean deleteJob(int jobId);

}
