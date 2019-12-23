package com.corlogy.service;

import com.corlogy.model.Applyjob;
import com.corlogy.model.Job;
import com.corlogy.repository.ApplyJobRepo;
import com.corlogy.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyJobServiceImpl implements ApplyJobService {
    @Autowired
    JobRepo jobRepo;
    @Autowired
    ApplyJobRepo applyJobRepo;

    @Override
    public Applyjob addApplyJob(int idJob,Applyjob applyjob) {
        Job job = jobRepo.getOne(idJob);
        if(job==null || applyjob==null){
            throw new NullPointerException("you must enter information");
        }
        applyjob.setIdJob(idJob);
        applyJobRepo.save(applyjob);
        return applyjob;
    }

    @Override
    public boolean deleteApplyJob(int idApplyJob) {
        if(applyJobRepo.getOne(idApplyJob)==null){
            return false;
        }
        applyJobRepo.deleteById(idApplyJob);
        return true;
    }

    @Override
    public List<Applyjob> getAll() {
        return applyJobRepo.findAll();
    }
}
