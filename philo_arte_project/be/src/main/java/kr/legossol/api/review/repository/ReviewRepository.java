package kr.legossol.api.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.review.domain.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    
    
}
