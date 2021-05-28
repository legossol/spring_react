package kr.legossol.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import kr.legossol.api.funding.domain.PageRequestDto;
import kr.legossol.api.funding.repository.FundingRepository;
import kr.legossol.api.funding.service.FundingServiceImpl;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class RepositoryTest {
    @Autowired
    private FundingRepository repo;
//     private FundingServiceImpl service;
//     @Test@Commit@Transactional
//     void test1(){
//         List<Funding> f = repo.getAllFundings();
//         for(Funding funding :f){
//         System.out.println(funding.getContent());
//         System.out.println(funding.getGoalPrice());
//         System.out.println(funding.getHashtag());
//         System.out.println(funding.getTitle());
//         System.out.println(funding.getFundingId());
//     }
// }

//     @Test@Commit@Transactional
//     void test2(){
//         List<Funding>  f = repo.getOneFunding(5L);
        
//         for(Funding funding :f){
//             System.out.println(funding.getContent());
//             System.out.println(funding.getGoalPrice());
//             System.out.println(funding.getHashtag());
//             System.out.println(funding.getTitle());
//             System.out.println(funding.getFundingId());
//         }
//     }

//     @Test@Commit@Transactional
//     void test3(){
//         List<Funding>  f = repo.searchFundingsByTitle("밤에");
//         for(Funding funding :f){
//             System.out.println(funding.getContent());
//             System.out.println(funding.getGoalPrice());
//             System.out.println(funding.getHashtag());
//             System.out.println(funding.getTitle());
//             System.out.println(funding.getFundingId());
//         }
//     }
//     @Test@Commit@Transactional
//     void test4(){
//         List<Funding>  f = repo.searchFundingByContent("안녕");
//         for(Funding funding :f){
//             System.out.println(funding.getContent());
//             System.out.println(funding.getGoalPrice());
//             System.out.println(funding.getHashtag());
//             System.out.println(funding.getTitle());
//             System.out.println(funding.getFundingId());
//         }
//     }
//     @Test@Commit@Transactional
//     void test5(){
//         List<Funding>  f = repo.searchAllListByArtistId(5L);
//         for(Funding funding :f){
//             System.out.println(funding.getContent());
//             System.out.println(funding.getGoalPrice());
//             System.out.println(funding.getHashtag());
//             System.out.println(funding.getTitle());
//             System.out.println(funding.getFundingId());
//         }
//     }
//     // @Test@Commit@Transactional
//     // void test(){
//     //     List<Funding>  f = repo
//     //     for(Funding funding :f){
//     //         System.out.println(funding.getContent());
//     //         System.out.println(funding.getGoalPrice());
//     //         System.out.println(funding.getHashtag());
//     //         System.out.println(funding.getTitle());
//     //         System.out.println(funding.getFundingId());
//     //     }
//     // }
//     @Test@Commit@Transactional
//     void test7(){
//         Pageable pageable = PageRequest.of(0, 5);
//         Page<Funding> f = repo.getPageById(pageable, 5L);
//         for(Funding funding :f){
//             System.out.println(funding.getContent());
//             System.out.println(funding.getGoalPrice());
//             System.out.println(funding.getHashtag());
//             System.out.println(funding.getTitle());
//             System.out.println(funding.getFundingId());
//         }
//     }
    
    





//     // public void testList1(){
//     //     PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).getPageSize(10).buiild();

//     //     FundingPageDto<FundingDto, Funding> resultDto = service.getList(pageRequestDto);
//     //     for(FundingDto fundingdto : resultDto.getDtoList()){
//     //         System.out.println(fundingdto);
//     //     }
//     // }
//     // @Test@Commit@Transactional
//     // void test3(){
//     //     Pageable pageable = PageRequestDto.
        
//     //     repo.getRecent(pageable);
//     //     pageable = PageReques
//     // }
//     // @Test@Commit@Transactional
//     // public void testList(){
//     //     PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).perPage(10).build();
        
//     //     FundingPageDto<FundingDto, Funding> resultDto = service.getList(pageRequestDto);

//     //     System.out.println("PREV: " +resultDto.isPrev());
//     //     System.out.println("NEXT: " + resultDto.isNext());
//     //     System.out.println("TOTAL:" + resultDto.getTotalPage());
//     //     System.out.println("=======================-=========");
//     //     for(FundingDto fundingdto : resultDto.getDtoList()){
//     //         System.out.println(fundingdto);
//     //     }
//     //     System.out.println("=======================-=========");
//     //     resultDto.getPageList().forEach(i -> System.out.println(i));
//     // }

// @Test@Commit@Transactional
//     void test3(){
//         Pageable pageable = PageRequest.of(0, 1);
//         repo.onlyList(pageable);
        

//         System.out.println("PREV: " +resultDto.isPrev());
//         System.out.println("NEXT: " + resultDto.isNext());
//         System.out.println("TOTAL:" + resultDto.getTotalPage());
//         System.out.println("=======================-=========");
//         for(FundingDto fundingdto : resultDto.getDtoList()){
//             System.out.println(fundingdto);
//         }
//         System.out.println("=======================-=========");
//         resultDto.getPageList().forEach(i -> System.out.println(i));
//     }
//     @Test@Commit@Transactional
//     public void testList(){
//         PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).perPage(10).build();
        
//         FundingPageDto<FundingDto, Funding> resultDto = service.getList(pageRequestDto);

//         System.out.println("PREV: " +resultDto.isPrev());
//         System.out.println("NEXT: " + resultDto.isNext());
//         System.out.println("TOTAL:" + resultDto.getTotalPage());
//         System.out.println("=======================-=========");
//         for(FundingDto fundingdto : resultDto.getDtoList()){
//             System.out.println(fundingdto);
//         }
//         System.out.println("=======================-=========");
//         resultDto.getPageList().forEach(i -> System.out.println(i));
//     }
}