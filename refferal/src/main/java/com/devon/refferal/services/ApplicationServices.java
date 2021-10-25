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
    public void deleteApplications(int aid)
    {
        applicationRepository.deleteById(aid);
    }
    public void updateApplications(Applications applications, int appId)
    {
        applications.setId(appId);
        applicationRepository.save(applications);
    }

}
