package com.devon.refferal.services;

import java.util.List;

import com.devon.refferal.dao.JobRepository;
import com.devon.refferal.entites.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobServices {

    @Autowired
    private JobRepository jobRepository;
    //private static List<Jobs> list = new ArrayList<>();

    /*static {
        list.add(new Jobs(12, "Java Developer", "Java Development", "5-6 Exp", "Amrita"));
        list.add(new Jobs(13, "Steve", "Rogers", "rogers@gmail.com", "Avengers"));
        list.add(new Jobs(14, "anurag", "Sk", "sk@gmail.com", "Avengers"));

    }*/

    // get all jobs
    public List<Jobs> getAllJobs() {
        List<Jobs> list = (List<Jobs>) this.jobRepository.findAll();
        return list;
    }

    // get jobs by ID
    public Jobs getJobById(int id) {
        Jobs jobs = null;
        try {

           // jobs = list.stream().filter(e -> e.getId() == id).findFirst().get();
           this.jobRepository.findById(id);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return jobs;
    }

    // add jobs
    public Jobs addjob(Jobs j) {
        Jobs result = jobRepository.save(j);
        return result;
    }

    // delete jobs
    public void deleteJobs(int jid) {
        //list = list.stream().filter(job -> job.getId() != jid).collect(Collectors.toList());
        jobRepository.deleteById(jid);
    }

    // Update job
    public void updateJob(Jobs job, int jobsId) {
        
        job.setId(jobsId);
        jobRepository.save(job);
    }
}
