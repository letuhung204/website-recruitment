package com.corlogy.service;

import com.corlogy.model.Applyjob;

import java.util.List;

public interface ApplyJobService {

    //insert apply job in DB with id job
    Applyjob addApplyJob(int idJob, Applyjob applyjob);

    //delete applyJob
    boolean deleteApplyJob(int idApplyJob);
    //get all
    List<Applyjob> getAll();
}
