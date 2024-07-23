package com.example.JobApplication1.review.impl;


import com.example.JobApplication1.company.Company;
import com.example.JobApplication1.company.CompanyService;
import com.example.JobApplication1.review.Review;
import com.example.JobApplication1.review.ReviewRepository;
import com.example.JobApplication1.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

  ReviewRepository reviewRepository;
  CompanyService companyService;

  public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
    this.reviewRepository = reviewRepository;
    this.companyService = companyService;
  }




  @Override
  public List<Review> getAllReview(Long companyId) {
     List<Review> reviews =   this.reviewRepository.findByCompanyId(companyId);
    return reviews;
  }

  @Override
  public Review addReview(Long companyId, Review review) {
      Company company =  this.companyService.getById(companyId);
      if(company!=null){
           review.setCompany(company);
           return this.reviewRepository.save(review);
      }
    return null;
  }

  @Override
  public Review updateReview(Long companyId, Long reviewId, Review updatedReview) {
         List<Review> reviews =  this.reviewRepository.findByCompanyId(companyId);
        Review review1 =  reviews.stream().filter(t->t.getId().equals(reviewId)).findFirst().get();
        review1.setTitle(updatedReview.getTitle());
        review1.setDescription(updatedReview.getDescription());
        review1.setRating(updatedReview.getRating());
        return reviewRepository.save(review1);
  }

  @Override
  public Review getReviewByid(Long companyId, Long reviewId) {
     List<Review> reviews =   this.reviewRepository.findByCompanyId(companyId);
     return  reviews.stream().filter((a)->a.getId().equals(reviewId)).findFirst().orElse(null);
  }

  @Override
  public boolean removeReview(Long companyId, Long reviewId) {
               if(companyService.getById(companyId)!=null &&  reviewRepository.existsById(reviewId)){
                           reviewRepository.deleteById(reviewId);
                           return  true;
               }
    return false;
  }
}
