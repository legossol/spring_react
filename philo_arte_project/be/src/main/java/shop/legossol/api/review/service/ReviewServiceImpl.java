package shop.jinwookoh.api.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import shop.jinwookoh.api.common.service.AbstractService;
import shop.jinwookoh.api.review.domain.Review;
import shop.jinwookoh.api.review.repository.ReviewRepository;
@Service
public class ReviewServiceImpl extends AbstractService<Review> implements ReviewService{

    // private final ReviewRepository repository;
    
    @Override
    public Long save(Review t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Review> findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Review> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Review> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long delete(Review t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Boolean existsById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        
    }

    

}
