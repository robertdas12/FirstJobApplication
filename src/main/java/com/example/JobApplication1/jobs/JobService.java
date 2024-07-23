package com.example.JobApplication1.jobs;

import java.util.List;

public interface JobService {

     public Job createJob(Job job);
     public List<Job> getAllJob();

     public Job  getJobById(Long id);

     public Job  updateJob(Long id , Job job);

     public boolean deleteJob(Long id);
}
