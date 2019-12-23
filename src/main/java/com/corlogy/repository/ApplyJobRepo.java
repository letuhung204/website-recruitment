package com.corlogy.repository;

import com.corlogy.model.Applyjob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyJobRepo extends JpaRepository<Applyjob,Integer> {

}
