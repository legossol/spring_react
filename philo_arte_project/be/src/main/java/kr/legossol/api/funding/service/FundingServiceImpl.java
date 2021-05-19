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
public class FundingServiceImpl extends AbstractService<FundingDto> implements FundingService{

    private final FundingRepository repository;

    @Override
    public void updateFunding(Long fundingId, Funding funding) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Funding> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String save(FundingDto t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FundingDto> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FundingDto> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete(FundingDto t) {
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

    // 

  
    
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
