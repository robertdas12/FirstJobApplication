package com.example.JobApplication1.jobs;


import com.example.JobApplication1.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")
public class Job {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String title;
      private String description;
      private String minSalary;
      private String maxSalary;
      private String location;


      @ManyToOne(cascade = CascadeType.ALL)
      private Company company;
}
