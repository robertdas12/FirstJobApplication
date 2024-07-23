package com.example.JobApplication1.company;



import com.example.JobApplication1.jobs.Job;
import com.example.JobApplication1.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {

     @Id
     @GeneratedValue(strategy =  GenerationType.IDENTITY)
     private  Long id;
     private String name;
     private  String description;


     @JsonIgnore
      @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
     private List<Job> jobList;



      @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
      private List<Review> reviews;
}
