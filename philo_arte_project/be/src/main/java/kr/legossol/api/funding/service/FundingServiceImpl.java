package kr.legossol.api.funding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FundingServiceImpl extends AbstractService<Funding> implements FundingService{

    private final FundingRepository repository;

    @Override
    @Transactional
    public String save(Funding t) {
        // TODO Auto-generated method stub
        return (repository.save(t) != null) ? "Success" : "Failed";
    }
    @Override
    public Optional<Funding> findById(Long id){
        return Optional.ofNullable(repository.getOne(id));
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
    public String delete(Funding funding) {
        repository.delete(funding);
        return (findById(funding.getFundingId()).orElse(null)==null) ? "삭제성공": "삭제실패";
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
