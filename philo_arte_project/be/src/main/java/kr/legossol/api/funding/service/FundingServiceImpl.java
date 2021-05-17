package kr.legossol.api.funding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FundingServiceImpl extends AbstractService<Funding> implements FundingService{

    private final FundingRepository repository;

    @Override
    public Long save(Funding t) {
        // TODO Auto-generated method stub
        return (repository.save(t) != null) ? 1L : 0L;
    }

    @Override
    public Optional<Funding> findById(long id) {
        
        return repository.findById(id);
    }

    @Override
    public List<Funding> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Funding> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long delete(Funding funding) {
        repository.delete(funding);
        return (findById(funding.getFundingId()).orElse(null)==null) ? 1L: 0L;
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
    public void deleteById(long fundingNo) {
        repository.deleteById(fundingNo);
        
    }

    @Override
    public void updateFunding(Long fundingId, Funding funding) {
        Funding i = repository.findById(fundingId).get();
        i.setTitle(funding.getTitle());
        i.setContent(funding.getContent());
        i.setGoalPrice(funding.getGoalPrice());
        repository.save(i);

    }
    
    // @Override
    // public Optional<Funding> updateFunding(Long fundingNo, Funding newFunding){
    //     return repository.findById(fundingNo)
    //         .map(oldFunding ->{
    //             Funding updating = oldFunding.updateWith(newFunding);
    //             return repository.save(updating);
    //         });
    //     }
    // }
    
}
