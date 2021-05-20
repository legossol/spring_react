package kr.legossol.api.funding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.funding.domain.FundingFile;

@Repository
public interface FundingFileRepository extends JpaRepository<FundingFile, Long>{
    
}
