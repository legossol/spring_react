package kr.legossol.api;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;

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
        List<Funding> result = repo.getAllFundings();
       for(Funding funding: result){
           System.out.println(funding);
           log.info(result);
    }
    }
    @Transactional
    @Test
    @Commit
    public void testFindAllpage() {
        Pageable pageable = PageRequest.of(0, 10);
        repo.findAllFundingTitleWithPage(pageable).get().forEach(funding->{
            log.info(funding);
            System.out.println(funding.getTitle());
            log.info("-----------------");
        });
    }
    @Test
    void updateFunding(){
        
    }
    @Test
    void findFundings(){
        Funding f = repo.findById(1L).orElse(null);
        System.out.println(f);
        log.info("info :----------", f);
    }
    @Test 
    void deleteFunding(){
        Funding funding = repo.findById(91L).orElseThrow(IllegalArgumentException::new);
        repo.delete(funding);
    }
}
