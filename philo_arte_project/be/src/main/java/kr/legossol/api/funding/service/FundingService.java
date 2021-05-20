package kr.legossol.api.funding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;

public interface FundingService {
    // public Optional<Funding> updateFunding(Long fundingno,Funding funding);
    // public Funding updateWith(Funding newFunding);
    Funding updateFunding(Long fundingId,FundingDto fundingDto);
    public Optional<Funding> findById(Long id);
    public Page<FundingDto> findFundingPaging(Integer page, String title);
    
    List<Funding> getAllFundings(FundingDto dto);
    default Funding dtoToEntity(FundingDto dto){
        Funding funding = Funding.builder()
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .goalPrice(dto.getGoalPrice())
                        .hashtag(dto.getHashtag())
                        .build();
                        return funding;
    }
    FundingDto getFundingById(long id);

}
