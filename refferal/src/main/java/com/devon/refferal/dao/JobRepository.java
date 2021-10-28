package com.devon.refferal.dao;

import com.devon.refferal.entites.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JobRepository extends JpaRepository <Jobs,Integer>{
    public Jobs findById(int id);
    
}
