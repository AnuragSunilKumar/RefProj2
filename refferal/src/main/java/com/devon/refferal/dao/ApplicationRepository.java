package com.devon.refferal.dao;

import com.devon.refferal.entites.Applications;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Applications,Integer> {
   
    
}
