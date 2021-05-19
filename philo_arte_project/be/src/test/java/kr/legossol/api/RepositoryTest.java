package kr.legossol.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.repository.FundingRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class RepositoryTest {
    @Autowired
    private FundingRepository repo;

    @Test
    void testSave(){
        Funding f = Funding.builder()
        .viewCnt(6)
       .title("새로운 제목 추가")
       .content("새로운 내용의 추가")
       .goalPrice(100000)
       .hashtag("hash")
       .build();
       repo.save(f);
    }
    @Test
    void testFindAllaboutFunding(){
        List<Funding> result = repo.findAllFundings();
       for(Funding funding: result){
           System.out.println(funding);
           log.info(result);
    }
    }
}
