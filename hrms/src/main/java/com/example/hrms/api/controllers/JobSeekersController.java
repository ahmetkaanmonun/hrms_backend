package com.example.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobSeekersService;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeekers;
import com.example.hrms.entities.concretes.DTOs.JobSeekersForRegisterDto;

@RestController
@RequestMapping("/api/jobseekers/")
@CrossOrigin
public class JobSeekersController {
	
	private final JobSeekersService jobSeekersService;

    @Autowired
    public JobSeekersController(JobSeekersService jobSeekersService) {
        this.jobSeekersService = jobSeekersService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeekers>> getAll(){
        return this.jobSeekersService.getAll();
    }

    @PostMapping("/findbyemailis")
    public DataResult<List<JobSeekers>> findByEmailIs(@RequestBody String email){
        return this.jobSeekersService.findByEmailIs(email.toLowerCase().trim());
    }

    @PostMapping("/findbyidentitynumberis")
    public DataResult<List<JobSeekers>> findByIdentityNumberIs(@RequestBody String nationalityId){
        return this.jobSeekersService.findByNationalityIdIs(nationalityId.trim());
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeekersForRegisterDto jobSeekers){
        return this.jobSeekersService.add(jobSeekers);
    }
	
	
	
	
	
	
	

}
