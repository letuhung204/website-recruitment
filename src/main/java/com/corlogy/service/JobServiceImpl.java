package com.corlogy.service;

import com.corlogy.model.Job;
import com.corlogy.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepo jobRepo;

    @Override
    public List<Job> listAllJob() {
        return jobRepo.findAll();
    }

    @Override
    public Job getJobById(int idJob) {
        Job job = jobRepo.getOne(idJob);
        if (job == null) {
            throw new NullPointerException("job with id : " + idJob + " is null");
        }
        return job;
    }

    @Override
    public Job saveJob(Job job) {
            return jobRepo.save(job);
    }

    @Override
    public Boolean deleteJob(int jobId) {
        if (getJobById(jobId) == null) {
            return false;
        }
        jobRepo.deleteById(jobId);
        return true;
    }
}
