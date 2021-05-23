package kr.legossol.api.funding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingFile;
import kr.legossol.api.funding.domain.FundingFileDto;

public interface FundingService {
   
    public Optional<Funding> findById(Long id);
    List<Funding> getAllFundings();
    default Funding dtoToEntity(FundingDto dto){
        Funding funding = Funding.builder()
                        .fundingId(dto.getFundingId())
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .goalPrice(dto.getGoalPrice())
                        .hashtag(dto.getHashtag())
                        .build();
                        return funding;
    }
    FundingDto getFundingById(long id);
    
    //============fileservice below==============
   

    String detailRegister(FundingFileDto fundingFileDto);

    ArrayList<FundingFileDto> registerFile(List<MultipartFile> uploadFiles);

    String deleteFile(Long fundingFileId);

    //============Pagingservice Below==============
    //page당 6개씩 불러오기(확정)but query문 moddate순 정렬 문제
    List<FundingDto> getListAllpage(Pageable pageable);

    List<FundingDto> searchPost(Pageable pageable, String keyword);

    public Page<FundingDto> findFundingPaging(Integer page, String title);

    

    Page<FundingDto> findPageByTitle(String title, Pageable pageable);
   
}
