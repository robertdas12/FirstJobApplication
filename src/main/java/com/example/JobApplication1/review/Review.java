package com.example.JobApplication1.review;



import com.example.JobApplication1.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private  String title;
     private String description;
     private  double rating;

     @JsonIgnore
     @ManyToOne
     private Company company;

}
