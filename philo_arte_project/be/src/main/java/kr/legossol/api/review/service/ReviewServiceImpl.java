package kr.legossol.api.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.review.domain.Review;
import kr.legossol.api.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl extends AbstractService<Review> implements ReviewService{

    private final ReviewRepository repository;

    @Override
    public Long save(Review review) {
        return (repository.save(review) !=null) ? 1L : 0L;
    }

    @Override
    public Optional<Review> findById(long id) {
        
        return repository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
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
    public Long delete(Review rv) {
        repository.delete(rv);
        return (findById(rv.getReviewId()).orElse(null) ==null)?1L:0L;
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
        repository.deleteById(id);
        
    }

    @Override
    public void updateReview(Long id, Review review) {
        Review rv = repository.findById(id).get();
        rv.setContent(review.getContent());
        repository.save(rv);
    }
}
