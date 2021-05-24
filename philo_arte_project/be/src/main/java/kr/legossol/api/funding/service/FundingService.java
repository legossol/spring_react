package kr.legossol.api.funding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingFile;
import kr.legossol.api.funding.domain.FundingFileDto;

public interface FundingService {
    String save(FundingDto requestDto);
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

    String delete(FundingDto postDto);
    void deleteById(long id);
    //============fileservice below==============
    String totalSave(FundingDto dto);


    List<FundingFileDto> getFileByFundingId(Long id);

    default FundingFile dtoToEntityResumeFile(FundingFileDto dto) {

        FundingFile fundingFile = FundingFile.builder().uuid(dto.getUuid()).fname(dto.getFname())
                .build();
        return fundingFile;
    }

    ArrayList<FundingFileDto> registerFile(List<MultipartFile> uploadFiles);

    String deleteFile(Long fundingFileId);

    //============Pagingservice Below==============
    List<FundingDto> getListAllpage(Pageable pageable);
   
    Page<FundingDto> searchInPage(String title,String content, Pageable pageable);
   
    Page<FundingDto> searchTitleAndContent(Pageable pageable, String keyword);
    


    
   
}
