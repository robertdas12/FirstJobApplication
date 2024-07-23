package com.example.JobApplication1.jobs.impl;


import com.example.JobApplication1.jobs.Job;
import com.example.JobApplication1.jobs.JobRepository;
import com.example.JobApplication1.jobs.JobService;
import com.example.JobApplication1.review.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

  JobRepository jobRepository;

  public JobServiceImpl(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }







  @Override
  public Job createJob(Job job) {
    return    this.jobRepository.save(job);
  }

  @Override
  public List<Job> getAllJob() {
    return this.jobRepository.findAll();

  }

  @Override
  public Job getJobById(Long id) {
    Optional<Job> job = this.jobRepository.findById(id);
    if(job.isPresent()){
       return job.get();
    }
    return null;
  }

  @Override
  public Job updateJob(Long id, Job job) {
       Optional<Job> job1 =  this.jobRepository.findById(id);
       if(job1.isPresent()){
               job1.get().setTitle(job.getTitle());
               job1.get().setDescription(job.getDescription());
               job1.get().setMinSalary(job.getMinSalary());
               job1.get().setMaxSalary(job.getMaxSalary());
               job1.get().setLocation(job.getLocation());
             return  this.jobRepository.save(job1.get());
       }
    return null;
  }


  @GetMapping("/getReview/{reviewId")
  public ResponseEntity<Review>  getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
       return  null;
  }



  @Override
  public boolean  deleteJob(Long id) {
        this.jobRepository.deleteById(id);
        return true;
  }


}
