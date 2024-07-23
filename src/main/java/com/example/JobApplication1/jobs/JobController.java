package com.example.JobApplication1.jobs;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {


  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  JobService jobService;



    @PostMapping("/createJob")
    public ResponseEntity<Job> createJob(@RequestBody Job job){
          Job job1 =   this.jobService.createJob(job);
          if(job1!=null){
               return   new ResponseEntity<>(job1, HttpStatus.CREATED);
          }else{
              return  new ResponseEntity<>(null);
          }
    }


    @GetMapping("/getAllJob")
    public ResponseEntity<List<Job>>  getAllJobs(){
       List<Job> listJob =   this.jobService.getAllJob();
       if(listJob!=null){
           return new ResponseEntity<>(listJob,HttpStatus.OK);
       }
       else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }


    @GetMapping("/getJobById/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
          Job job =   this.jobService.getJobById(id);
          if(job!=null){
                return  new ResponseEntity<>(job,HttpStatus.OK);
          }else {
             return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }

    @PutMapping("/updatejob/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id,@RequestBody Job job){
           Job job1 = this.jobService.updateJob(id,job);
           if(job1!=null){
                   return  new ResponseEntity<>(job1,HttpStatus.OK);
           }
           else{
              return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteJob(@PathVariable Long id){
           boolean b =  this.jobService.deleteJob(id);
           if(b==true){
              return  new ResponseEntity<>(HttpStatus.OK);
           }else {
             return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
    }


}
