package com.example.JobApplication1.review;

import java.util.List;

public interface ReviewService {

       public  List<Review>  getAllReview(Long companyId);
       public  Review addReview(Long companyId,Review review);

       public Review updateReview(Long companyId,Long reviewId,Review updatedReview);

       public  Review getReviewByid(Long companyId,Long reviewId);

       public  boolean removeReview(Long companyId,Long reviewId);
}
