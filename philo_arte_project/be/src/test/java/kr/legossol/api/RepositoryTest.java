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
    @Commit
    @Transactional
    void testFindFundingByArtist(){
        List<Funding> result = repo.searchAllListByArtistId(55L);
        System.out.println("result::::::::::"+result);
        log.info("log좀 보자:::::::::::::::", result);
    }
    @Test@Commit@Transactional
    void testFindFundingByArtistId(){
        List<Funding> result = repo.searchFundingByArtistId(10L);
        System.out.println("result::::::::::"+result);
        log.info("log좀 보자:::::::::::::::", result);
    }
    @Test@Commit@Transactional
    void testSearchByTitle(){
        List<Funding> result = repo.searchFundingsByTitle("기부");
        System.out.println("result::::::::::"+result);
        log.info("log좀 보자:::::::::::::::", result);
    }
    

    // @Test
    // void testFindAllaboutFunding(){
    //     List<Funding> result = repo.getAllFundings();
    //    for(Funding funding: result){
    //        System.out.println("getallfunding:::::::" + funding);
    //        log.info(result);}}
    // @Transactional
    // @Test
    // @Commit
    // public void testFindAllpage() {
    //     Pageable pageable = PageRequest.of(0, 10);
    //     repo.findAllFundingTitleWithPage(pageable).get().forEach(funding->{
    //         log.info(funding);
    //         System.out.println(funding.getTitle());
    //         log.info("-----------------");
    //     });
    // }
    // @Test
    // void updateFunding(){
        
    // }
    // @Test
    // void findFundings(){
    //     Funding f = repo.findById(1L).orElse(null);
    //     System.out.println(f);
    //     log.info("info :----------", f);
    // }
    // @Test 
    // void deleteFunding(){
    //     Funding funding = repo.findById(91L).orElseThrow(IllegalArgumentException::new);
    //     repo.delete(funding);
    // }

    // @Test
    // void findAllByHashtag(){
    //     List<Funding> result = repo.findAllByHashtag();
    //     System.out.println("resulte >>>>>>>>>>>>>>>>>>>"+result);
    //     log.info("info:::::::::::::::::::",result);

    // @Test
    // public void findAllUsingHashtag(){
    //     Pageable page = PageRequest(0,1);
    //     repo.findAllUsingHashtag(pageable).get().forEach(funding->{
    //         log.info(funding);
    //         System.out.println(funding.getTitle());
    //     })
    // }
        // @Transactional
        // @Commit
        // @Test
        // public void testGetAllFundingInPage(){
        //     Pageable pageable = getPageable(0,1);
        //     repo.getAllFundingInPage(pageable).get().forEach(funding->{
        //        System.out.println("test Result ::::" +funding.getTitle()); 
        //     });
        // }

        // private Pageable getPageable(int stPage, int LastPage) {
        //     return PageRequest.of(stPage, LastPage);
        // }

    


    // }
}
