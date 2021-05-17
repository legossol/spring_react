package kr.legossol.api.funding.service;

import java.util.Optional;

import kr.legossol.api.funding.domain.Funding;

public interface FundingService {
    // public Optional<Funding> updateFunding(Long fundingno,Funding funding);
    // public Funding updateWith(Funding newFunding);
    public void updateFunding(Long fundingId,Funding funding);
}
