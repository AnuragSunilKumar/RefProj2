package com.devon.refferal.services;

import java.util.List;

import com.devon.refferal.dao.ApplicationRepository;
import com.devon.refferal.entites.Applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationServices {
    
    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Applications> getAllApplications()
    {
        List<Applications> list = (List<Applications>) this.applicationRepository.findAll();
        return list;
    }

    // add applications
    public Applications addApplications(Applications a)
    {
        Applications result = applicationRepository.save(a);
        return result;

    }
    
    //delete applications
    public void deleteApplications(int aid)
    {
        applicationRepository.deleteById(aid);
    }
    
    //update applications
    public Applications updateApplications(Applications applications, int appId)
    {
        applications.setId(appId);
       Applications result =  applicationRepository.save(applications);
       return result;
    }

}
