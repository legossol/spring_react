package kr.legossol.api.review.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.legossol.api.review.domain.Review;
import kr.legossol.api.review.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewServiceImpl service;
//댓글은 따로 주소를 안둘거 같지만 일단 crud만든다.

    @GetMapping("/list")
    public ResponseEntity<List<Review>> reviewList() {
      
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> saveReview(@RequestBody Review review){
        service.save(review);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/list/{reviewId}")
    public ResponseEntity<Review> getOneReview(@PathVariable("reviewId")Long reviewId){
        Optional<Review> rv = service.findById(reviewId);
        return new ResponseEntity<Review>(rv.get(),HttpStatus.OK);
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable("reviewId")Long reviewId,@RequestBody Review review){
        service.updateReview(reviewId, review);
        return ResponseEntity.ok("수정 성공");
    }


    @DeleteMapping("/list/{reviewId}")
    public ResponseEntity<String> delReview(@PathVariable("reviewId")Long reviewId){
        service.deleteById(reviewId);
        return ResponseEntity.ok("리뷰 삭제 성공");
    }

    



    

}
