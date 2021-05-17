package kr.legossol.api.funding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.funding.domain.Funding;
@Repository
public interface FundingRepository extends JpaRepository<Funding,Long>{
    
}
