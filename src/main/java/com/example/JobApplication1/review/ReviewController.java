package com.example.JobApplication1.review;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

  ReviewService reviewService;


  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }



@GetMapping("/allreviews")
  public ResponseEntity<List<Review>>  getAllReviews(@PathVariable Long companyId){
        List<Review> reviews = this.reviewService.getAllReview(companyId);
        if(reviews!=null){
             return  new ResponseEntity<>(reviews, HttpStatus.OK);
        }else {
           return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  }


    @PostMapping("/addReview")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody  Review review){
      System.out.println("controller review title "  + review.getTitle());
      System.out.println("controller review description "  + review.getDescription());
         Review review1 = this.reviewService.addReview(companyId,review);
         if(review1!=null){
             return  new ResponseEntity<>("one review added",HttpStatus.OK);
         }
         else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/updateReview/{reviewId}")
    public  ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
       Review review1 =  this.reviewService.updateReview(companyId,reviewId,review);
       if(review1!=null){
          return  new ResponseEntity<>("review updated ", HttpStatus.OK);
       }
        return  null;
    }

    @GetMapping("/getById/{reviewId}")
    public  ResponseEntity<Review> getReviewId(@PathVariable Long companyId,@PathVariable Long reviewId){
         Review review =  this.reviewService.getReviewByid(companyId,reviewId);
         if(review!=null)
            return  new ResponseEntity<>(review,HttpStatus.OK);
         else
           return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/removeReview/{reviewId}")
    public ResponseEntity<String> removeReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean result =  this.reviewService.removeReview(companyId,reviewId);
         if(result==true)
             return  new ResponseEntity<>("review deleted successfully",HttpStatus.OK);
         else
            return  new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
