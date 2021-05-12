package shop.jinwookoh.api.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.jinwookoh.api.review.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{
    
}
