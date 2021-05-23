package kr.legossol.api;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;


import javassist.runtime.Desc;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingPageDto;
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
    void testSearchByTitle(){
        List<Funding> result = repo.searchFundingsByTitle("기부");
        System.out.println("result::::::::::"+result);
        log.info("log좀 보자:::::::::::::::", result);
    }
    @Test@Commit@Transactional
    void testSearchBycontent(){
        List<Funding> result = repo.searchFundingByContent("안경");
        System.out.println("result::::::::::"+result.size());
        log.info("log좀 보자:::::::::::::::", result);
    }
    @Test@Commit@Transactional
    void testSearchByhash(){
        List<Funding> result = repo.searchFundingByHashtag("건강");
        System.out.println("result::::::::::"+result.size());
        log.info("log좀 보자:::::::::::::::", result);
    }

 /*======================================bined with artist========================================*/
    @Test@Commit@Transactional
    void testFindFundingByArtistId(){
        List<Funding> result = repo.searchFundingByArtistId(10L);
        System.out.println("result::::::::::"+result);
        log.info("log좀 보자:::::::::::::::", result);
    }

    /*======================================bined with page========================================*/
    @Test@Commit@Transactional
    void testpaging(int page){
        Page<Funding> f = repo.getAllPaging(PageRequest.of(1, 6, Direction.DESC));
        System.out.println(f);
        
                        // .stream().map(Funding -> ModelMapperUtils.getModelMapper()
                        // .map(Funding, FundingDto.class)).collect(Collectors.toList());
    }
    @Test@Commit@Transactional
    void search(){
        String findkeyword = "당신";
        Pageable pageable = PageRequest.of(0, 4);
        List<Funding> posst = repo.searchIndexList(findkeyword, pageable);

        Funding f1 = (Funding) posst.get(0);
        Funding f2 = (Funding) posst.get(1);

        System.out.println(posst);

    }
}
            
