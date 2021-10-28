package com.devon.refferal.ControllerTest;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.devon.refferal.controller.JobController;
import com.devon.refferal.dao.JobRepository;
import com.devon.refferal.entites.Jobs;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(JobController.class)
public class JobContollerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	JobRepository jobRepository;
	
	
	Jobs jobs1 = new Jobs(1,"PHP Developer","PHP Development","8-9yrs","Mayank");
	Jobs jobs2 = new Jobs(2,"Java Developer","Java Development","9-10yrs","SUmanth");
	Jobs jobs3 = new Jobs(3,"ReactJs Developer","ReactJS Development","5-6yrs","Priyankka");
	
	
	@Test
	public void getAllJobs_success() throws Exception {
	    List<Jobs> jobs = new ArrayList<>(Arrays.asList(jobs1, jobs2, jobs3));
	    
	    Mockito.when(jobRepository.findAll()).thenReturn(jobs);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/jobs")
	            .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
	             .andExpect(status().isOk()).andExpect(jsonPath("$[2].jobName", is("ReactJS Developer")));
	            

	}
	
}
