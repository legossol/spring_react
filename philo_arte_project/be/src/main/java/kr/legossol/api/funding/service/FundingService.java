package kr.legossol.api.funding.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;

public interface FundingService {
    // public Optional<Funding> updateFunding(Long fundingno,Funding funding);
    // public Funding updateWith(Funding newFunding);
    public void updateFunding(Long fundingId,Funding funding);
    public Optional<Funding> findById(Long id);
    public Page<FundingDto> findFundingPaging(Integer page, String title);
    
}
