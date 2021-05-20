package kr.legossol.api.funding.service;

import java.util.List;
import java.util.Optional;

import com.amazonaws.services.codestarconnections.model.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.common.util.ModelMapperUtils;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class FundingServiceImpl extends AbstractService<FundingDto> implements FundingService{

    private final FundingRepository repository;

    @Override
    public Optional<Funding> findById(Long id) {
       return null;
    }

    @Override
    public List<FundingDto> findAll() {
        
        return null;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FundingDto> getOne(long id) {
        // Funding postRequest = Funding.of(fundingDto)
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

    @Override
    public Page<FundingDto> findFundingPaging(Integer page, String title) {
        
        return findFundingPaging(page, title).map(
            funding -> ModelMapperUtils.getModelMapper().map(funding,FundingDto.class));
    }


    @Override
    @Transactional
    public String save(FundingDto requestDto) {
        Funding toEntityRequest = Funding.of(requestDto);
        toEntityRequest.saveRequest(requestDto);
        return (repository.save(toEntityRequest)!= null) ? "success" : "Fail";

        // //repo에 인자로 넘겨주기 dto to entity
        // Funding postRequest = Funding.of(requestDto);
        // //db에 저장
        // Funding funding = repository.save(postRequest);
        // System.out.println(funding + " dto :" + requestDto);
        // log.info(requestDto+"funding :" + funding);
        // //성공 혹은 실패를 메시지와 함께 entity->dto로 보냄
        // return (FundingDto.toDto(funding)!=null)?"saved":"unsaved";
        // (repository.save(funding)!=null)?"saved":"unsaved";
        
    }
    

    @Override
    public void updateFunding(Long fundingId, FundingDto fundingDto) {
        // Funding postRequest = Funding.of(fundingDto);

        // Funding f = repository.findById(fundingId)
        // .orElseThrow(()->new ResourceNotFoundException("Id is not found"));
        // Funding funding = 
        // assert
        return ;

    }
    @Transactional
    @Override
    public List<Funding> getAllFundings(FundingDto dto) {
        Funding toEntityFunding = Funding.of(dto);
        Funding funding = toEntityFunding.builder()
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .goalPrice(dto.getGoalPrice())
                        .hashtag(dto.getHashtag())
                        .build();
                        
        return repository.findAllFundings();
    }
    
    @Override
    public FundingDto getFundingById(long id) {
        Funding funding = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        FundingDto dto = FundingDto.toDto(funding);
        return dto;
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
